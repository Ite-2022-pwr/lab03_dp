package pl.pwr.ite.service;

import pl.pwr.ite.model.entity.Report;
import pl.pwr.ite.model.filter.ReportFilter;

import java.util.UUID;

public interface ReportService extends EntityService<Report> {
    Report get(ReportFilter filter);
    Report getByRegistrationId(UUID registrationId);
}
