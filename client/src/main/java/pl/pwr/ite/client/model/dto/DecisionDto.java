package pl.pwr.ite.client.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DecisionDto {

    private RegistrationDto registration;

    private UserDto user;

    private String description;
}
