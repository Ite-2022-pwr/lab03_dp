package pl.pwr.ite.server.web.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.Report;
import pl.pwr.ite.server.web.dto.ReportDto;

@Component
public class ReportMapper extends MapperBase<Report, ReportDto> {

    private final RegistrationMapper registrationMapper;

    public ReportMapper(RegistrationMapper registrationMapper) {
        super(ReportDto.class);
        this.registrationMapper = registrationMapper;
    }

    @Override
    public void transform(Report source, ReportDto destination) {
        destination.setDescription(source.getDescription());
        map(destination::setRegistration, source.getRegistration(), registrationMapper);
    }
}
