package pl.pwr.ite.server.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.server.web.dto.DecisionDto;
import pl.pwr.ite.server.web.mapper.DecisionMapper;
import pl.pwr.ite.service.DecisionService;
import pl.pwr.ite.service.RegistrationService;
import pl.pwr.ite.service.UserService;

@Component
public class DecisionFacade extends EntityServiceFacade<Decision, DecisionDto, DecisionService, DecisionMapper> {

    private final UserService userService;
    private final RegistrationService registrationService;

    public DecisionFacade(DecisionService service, DecisionMapper mapper, UserService userService, RegistrationService registrationService) {
        super(service, mapper);
        this.userService = userService;
        this.registrationService = registrationService;
    }

    public Decision create(DecisionDto dto) {
        var decision = new Decision();
        decision.setDescription(dto.getDescription());

        var user = userService.findById(dto.getUser().getId());
        decision.setUser(user);

        var registration = registrationService.findById(dto.getRegistration().getId());
        decision.setRegistration(registrationService.saveAndFlush(registration));

        return saveAndFlush(decision);
    }
}
