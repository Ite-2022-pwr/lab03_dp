package pl.pwr.ite.service;

import pl.pwr.ite.model.entity.Tree;
import pl.pwr.ite.model.filter.TreeFilter;

import java.util.Collection;

public interface TreeService extends EntityService<Tree> {
    Collection<Tree> getList(TreeFilter filter);
}
