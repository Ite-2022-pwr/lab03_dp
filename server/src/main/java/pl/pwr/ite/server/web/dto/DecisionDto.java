package pl.pwr.ite.server.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DecisionDto {

    private RegistrationDto registration;

    private UserDto user;

    private String description;
}
