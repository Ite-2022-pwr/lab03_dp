package pl.pwr.ite.server.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.model.entity.User;
import pl.pwr.ite.server.web.dto.UserDto;
import pl.pwr.ite.server.web.mapper.UserMapper;
import pl.pwr.ite.service.UserService;

@Component
public class UserFacade extends EntityServiceFacade<User, UserDto, UserService, UserMapper> {

    public UserFacade(UserService service, UserMapper mapper) {
        super(service, mapper);
    }

    public User create(UserDto dto) {
        var user = new User();
        user.setType(dto.getType());
        user.setName(dto.getName());
        return saveAndFlush(user);
    }
}
