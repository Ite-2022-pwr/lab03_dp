package pl.pwr.ite.server.web.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.pwr.ite.server.model.entity.Registration;
import pl.pwr.ite.server.web.dto.RegistrationDto;

@Component
public class RegistrationMapper extends MapperBase<Registration, RegistrationDto> {

    private final UserMapper userMapper;
    private final TreeMapper treeMapper;
    private final ReportMapper reportMapper;
    private final DecisionMapper decisionMapper;

    public RegistrationMapper(@Lazy UserMapper userMapper, @Lazy TreeMapper treeMapper, @Lazy ReportMapper reportMapper, @Lazy DecisionMapper decisionMapper) {
        super(RegistrationDto.class);
        this.userMapper = userMapper;
        this.treeMapper = treeMapper;
        this.reportMapper = reportMapper;
        this.decisionMapper = decisionMapper;
    }

    @Override
    public void transform(Registration source, RegistrationDto destination) {
        destination.setStatus(source.getStatus());
        destination.setTime(source.getTime());
        destination.setId(source.getId());
        map(destination::setUser, source.getUser(), userMapper);
//        map(destination::setTrees, source.getTrees(), treeMapper);
//        map(destination::setReports, source.getReports(), reportMapper);
//        map(destination::setDecisions, source.getDecisions(), decisionMapper);
    }
}