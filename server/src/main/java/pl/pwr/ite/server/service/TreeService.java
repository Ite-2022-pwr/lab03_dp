package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.Tree;
import pl.pwr.ite.server.model.filter.TreeFilter;

import java.util.Collection;

public interface TreeService extends EntityService<Tree> {
    Collection<Tree> getList(TreeFilter filter);
}
