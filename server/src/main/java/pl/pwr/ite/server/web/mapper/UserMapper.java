package pl.pwr.ite.server.web.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.User;
import pl.pwr.ite.server.web.dto.UserDto;

@Component
public class UserMapper extends MapperBase<User, UserDto> {

    private final RegistrationMapper registrationMapper;
    private final DecisionMapper decisionMapper;

    public UserMapper(RegistrationMapper registrationMapper, DecisionMapper decisionMapper) {
        super(UserDto.class);
        this.registrationMapper = registrationMapper;
        this.decisionMapper = decisionMapper;
    }

    @Override
    public void transform(User source, UserDto destination) {
        destination.setId(source.getId());
        destination.setType(source.getType());
        destination.setName(source.getName());
//        map(destination::setRegistrations, source.getRegistrations(), registrationMapper);
//        map(destination::setDecisions, source.getDecisions(), decisionMapper);
    }
}
