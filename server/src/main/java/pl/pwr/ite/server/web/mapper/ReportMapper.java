package pl.pwr.ite.server.web.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.Report;
import pl.pwr.ite.server.web.dto.ReportDto;

@Component
public class ReportMapper extends MapperBase<Report, ReportDto> {
    private final UserMapper userMapper;
    private final RegistrationMapper registrationMapper;

    public ReportMapper(UserMapper userMapper, RegistrationMapper registrationMapper) {
        super(ReportDto.class);
        this.userMapper = userMapper;
        this.registrationMapper = registrationMapper;
    }

    @Override
    public void transform(Report source, ReportDto destination) {
        destination.setDescription(source.getDescription());
        map(destination::setRegistration, source.getRegistration(), registrationMapper);
        map(destination::setUser, source.getUser(), userMapper);
    }
}
