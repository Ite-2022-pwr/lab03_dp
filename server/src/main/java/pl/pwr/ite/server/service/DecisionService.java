package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.Decision;
import pl.pwr.ite.server.model.filter.DecisionFilter;

import java.util.UUID;

public interface DecisionService extends EntityService<Decision> {
    Decision get(DecisionFilter filter);
    Decision getByRegistrationId(UUID registrationId);
}
