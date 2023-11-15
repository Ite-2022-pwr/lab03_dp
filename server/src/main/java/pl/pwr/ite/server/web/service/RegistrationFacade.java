package pl.pwr.ite.server.web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.pwr.ite.model.entity.Registration;
import pl.pwr.ite.model.enums.RegistrationStatus;
import pl.pwr.ite.server.web.dto.RegistrationDto;
import pl.pwr.ite.server.web.mapper.RegistrationMapper;
import pl.pwr.ite.service.RegistrationService;
import pl.pwr.ite.service.UserService;

import java.time.LocalDateTime;

@Component
public class RegistrationFacade extends EntityServiceFacade<Registration, RegistrationDto, RegistrationService, RegistrationMapper> {

    private final TreeFacade treeFacade;
    private final UserService userService;

    public RegistrationFacade(RegistrationService service, RegistrationMapper mapper, TreeFacade treeFacade, UserService userService) {
        super(service, mapper);
        this.treeFacade = treeFacade;
        this.userService = userService;
    }

    public Registration create(RegistrationDto dto) {
        var registration = new Registration();
        registration.setStatus(RegistrationStatus.New);
        registration.setTime(LocalDateTime.now());
        var user = userService.findById(dto.getUser().getId());
        registration.setUser(user);
        registration = saveAndFlush(registration);
        for(var treeDto : dto.getTrees()) {
            treeDto.setRegistration(new RegistrationDto());
            treeDto.getRegistration().setId(registration.getId());
            registration.getTrees().add(treeFacade.create(treeDto));
        }
        return saveAndFlush(registration);
    }

    public Registration update(RegistrationDto dto) {
        var registration = getById(dto.getId());
        registration.setStatus(dto.getStatus());
        return saveAndFlush(registration);
    }
}
