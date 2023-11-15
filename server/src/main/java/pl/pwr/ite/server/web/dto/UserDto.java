package pl.pwr.ite.server.web.dto;

import lombok.Data;
import pl.pwr.ite.model.enums.UserType;

import java.util.UUID;

@Data
public class UserDto {

    private UUID id;

    private UserType type;

    private String name;

    private RegistrationDto[] registrations;

    private DecisionDto[] decisions;
}
