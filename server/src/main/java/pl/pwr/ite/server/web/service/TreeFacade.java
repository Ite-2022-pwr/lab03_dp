package pl.pwr.ite.server.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.server.model.entity.Tree;
import pl.pwr.ite.server.web.dto.TreeDto;
import pl.pwr.ite.server.web.mapper.TreeMapper;
import pl.pwr.ite.server.service.RegistrationService;
import pl.pwr.ite.server.service.TreeService;

@Component
public class TreeFacade extends EntityServiceFacade<Tree, TreeDto, TreeService, TreeMapper> {

    private final RegistrationService registrationService;

    public TreeFacade(TreeService service, TreeMapper mapper, RegistrationService registrationService) {
        super(service, mapper);
        this.registrationService = registrationService;
    }

    public Tree create(TreeDto dto) {
        var tree = new Tree();
        tree.setName(dto.getName());
        tree.setDiameter(dto.getDiameter());
        var registration = registrationService.findById(dto.getRegistration().getId());
        tree.setRegistration(registration);
        return saveAndFlush(tree);
    }
}
