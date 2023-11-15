package pl.pwr.ite.server.web.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.server.web.dto.DecisionDto;

@Component
public class DecisionMapper extends MapperBase<Decision, DecisionDto> {

    private final RegistrationMapper registrationMapper;
    private final UserMapper userMapper;

    public DecisionMapper(@Lazy RegistrationMapper registrationMapper, @Lazy UserMapper userMapper) {
        super(DecisionDto.class);
        this.registrationMapper = registrationMapper;
        this.userMapper = userMapper;
    }

    @Override
    public void transform(Decision source, DecisionDto destination) {
//        destination.setId(source.getId());
        destination.setDescription(source.getDescription());
        map(destination::setRegistration, source.getRegistration(), registrationMapper);
        map(destination::setUser, source.getUser(), userMapper);
    }
}
