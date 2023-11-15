package pl.pwr.ite.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.model.entity.Registration;
import pl.pwr.ite.model.filter.RegistrationFilter;
import pl.pwr.ite.model.repository.RegistrationRepository;
import pl.pwr.ite.service.RegistrationService;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@Service
public class RegistrationServiceImpl extends EntityServiceBase<Registration> implements RegistrationService {

    public RegistrationServiceImpl(RegistrationRepository repository) {
        super(repository);
    }

    @Override
    public Collection<Registration> getAllByUserId(UUID userId) {
        return ((RegistrationRepository) getRepository()).getAllByUserId(userId);
    }

    @Override
    public Collection<Registration> getAll() {
        return getRepository().findAll();
    }

    @Override
    public Collection<Registration> getList(RegistrationFilter filter) {
        if(filter.getUserId() == null) {
            return ((RegistrationRepository) getRepository()).getAllWithStatus(Arrays.asList(filter.getStatuses()));
        }
        return ((RegistrationRepository) getRepository()).getList(filter.getUserId(), Arrays.asList(filter.getStatuses()));
    }
}
