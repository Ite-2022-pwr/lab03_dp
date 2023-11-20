package pl.pwr.ite.server.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.server.model.entity.Decision;
import pl.pwr.ite.server.model.filter.DecisionFilter;
import pl.pwr.ite.server.model.repository.DecisionRepository;
import pl.pwr.ite.server.service.DecisionService;

import java.util.UUID;

@Service
public class DecisionServiceImpl extends EntityServiceBase<Decision> implements DecisionService {

    public DecisionServiceImpl(DecisionRepository repository) {
        super(repository);
    }

    @Override
    public Decision get(DecisionFilter filter) {
        return ((DecisionRepository) getRepository()).getByRegistrationId(filter.getRegistrationId()).orElse(null);
    }

    @Override
    public Decision getByRegistrationId(UUID registrationId) {
        return ((DecisionRepository) getRepository()).getByRegistrationId(registrationId).orElse(null);
    }
}
