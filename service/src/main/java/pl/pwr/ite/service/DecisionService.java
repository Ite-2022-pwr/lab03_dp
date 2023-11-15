package pl.pwr.ite.service;

import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.model.filter.DecisionFilter;

import java.util.UUID;

public interface DecisionService extends EntityService<Decision> {
    Decision get(DecisionFilter filter);
    Decision getByRegistrationId(UUID registrationId);
}
