package pl.pwr.ite.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.model.entity.Tree;
import pl.pwr.ite.model.filter.TreeFilter;
import pl.pwr.ite.model.repository.TreeRepository;
import pl.pwr.ite.service.TreeService;

import java.util.Collection;
import java.util.UUID;

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
