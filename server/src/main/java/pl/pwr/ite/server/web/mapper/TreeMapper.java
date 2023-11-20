package pl.pwr.ite.server.web.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.ite.server.model.entity.Tree;
import pl.pwr.ite.server.web.dto.TreeDto;

@Component
public class TreeMapper extends MapperBase<Tree, TreeDto> {

    private final RegistrationMapper registrationMapper;

    public TreeMapper(RegistrationMapper registrationMapper) {
        super(TreeDto.class);
        this.registrationMapper = registrationMapper;
    }

    @Override
    public void transform(Tree source, TreeDto destination) {
        destination.setName(source.getName());
        destination.setDiameter(source.getDiameter());
        map(destination::setRegistration, source.getRegistration(), registrationMapper);
    }
}
