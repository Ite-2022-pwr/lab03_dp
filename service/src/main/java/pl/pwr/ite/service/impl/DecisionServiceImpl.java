package pl.pwr.ite.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.model.filter.DecisionFilter;
import pl.pwr.ite.model.repository.DecisionRepository;
import pl.pwr.ite.service.DecisionService;

import java.util.Arrays;

@Service
public class DecisionServiceImpl extends EntityServiceBase<Decision> implements DecisionService {

    public DecisionServiceImpl(DecisionRepository repository) {
        super(repository);
    }

    @Override
    public Decision get(DecisionFilter filter) {
        return ((DecisionRepository) getRepository()).getByRegistrationId(filter.getRegistrationId()).orElse(null);
    }
}
