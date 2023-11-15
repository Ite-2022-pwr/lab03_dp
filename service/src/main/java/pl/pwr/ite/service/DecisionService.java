package pl.pwr.ite.service;

import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.model.filter.DecisionFilter;

public interface DecisionService extends EntityService<Decision> {
    Decision get(DecisionFilter filter);
}
