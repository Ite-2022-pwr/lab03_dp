package pl.pwr.ite.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.model.entity.Report;
import pl.pwr.ite.model.filter.ReportFilter;
import pl.pwr.ite.model.repository.ReportRepository;
import pl.pwr.ite.service.ReportService;

@Service
public class ReportServiceImpl extends EntityServiceBase<Report> implements ReportService {

    public ReportServiceImpl(ReportRepository repository) {
        super(repository);
    }

    @Override
    public Report get(ReportFilter filter) {
        return ((ReportRepository) getRepository()).findByRegistrationId(filter.getRegistrationId()).orElse(null);
    }
}
