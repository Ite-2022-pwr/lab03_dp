package pl.pwr.ite.server.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.server.model.entity.Tree;
import pl.pwr.ite.server.model.filter.TreeFilter;
import pl.pwr.ite.server.model.repository.TreeRepository;
import pl.pwr.ite.server.service.TreeService;

import java.util.Collection;

@Service
public class TreeServiceImpl extends EntityServiceBase<Tree> implements TreeService {

    public TreeServiceImpl(TreeRepository repository) {
        super(repository);
    }

    @Override
    public Collection<Tree> getList(TreeFilter filter) {
        return ((TreeRepository) getRepository()).getAllByRegistrationId(filter.getRegistrationId());
    }
}
