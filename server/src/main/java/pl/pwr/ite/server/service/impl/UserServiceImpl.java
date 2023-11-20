package pl.pwr.ite.server.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.server.model.entity.User;
import pl.pwr.ite.server.model.repository.UserRepository;
import pl.pwr.ite.server.service.UserService;

@Service
public class UserServiceImpl extends EntityServiceBase<User> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getByName(String name) {
        return ((UserRepository) getRepository()).findByName(name).orElse(null);
    }
}
