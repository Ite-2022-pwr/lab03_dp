package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.User;

public interface UserService extends EntityService<User> {
    User getByName(String name);
}
