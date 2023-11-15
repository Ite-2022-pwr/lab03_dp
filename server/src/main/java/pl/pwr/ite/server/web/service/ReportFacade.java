package pl.pwr.ite.server.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.Report;
import pl.pwr.ite.server.web.dto.ReportDto;
import pl.pwr.ite.server.web.mapper.ReportMapper;
import pl.pwr.ite.service.RegistrationService;
import pl.pwr.ite.service.ReportService;

@Component
public class ReportFacade extends EntityServiceFacade<Report, ReportDto, ReportService, ReportMapper> {

    private final RegistrationService registrationService;

    public ReportFacade(ReportService service, ReportMapper mapper, RegistrationService registrationService) {
        super(service, mapper);
        this.registrationService = registrationService;
    }

    public Report create(ReportDto dto) {
        var report = new Report();
        report.setDescription(dto.getDescription());
        var registration = registrationService.findById(dto.getRegistration().getId());
        report.setRegistration(registration);
        return saveAndFlush(report);
    }
}
