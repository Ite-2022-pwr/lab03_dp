package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.Report;
import pl.pwr.ite.server.model.filter.ReportFilter;

import java.util.UUID;

public interface ReportService extends EntityService<Report> {
    Report get(ReportFilter filter);
    Report getByRegistrationId(UUID registrationId);
}
