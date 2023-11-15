package pl.pwr.ite.service;

import pl.pwr.ite.model.entity.User;

public interface UserService extends EntityService<User> {
    User getByName(String name);
}
