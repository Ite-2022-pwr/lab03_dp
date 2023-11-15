package pl.pwr.ite.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.model.entity.User;
import pl.pwr.ite.model.repository.UserRepository;
import pl.pwr.ite.service.UserService;

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
