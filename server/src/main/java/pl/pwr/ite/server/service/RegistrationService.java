package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.Registration;
import pl.pwr.ite.server.model.filter.RegistrationFilter;

import java.util.Collection;
import java.util.UUID;

public interface RegistrationService extends EntityService<Registration> {

    Collection<Registration> getList(RegistrationFilter filter);
    Collection<Registration> getAllByUserId(UUID userId);
    Collection<Registration> getAll();
}
