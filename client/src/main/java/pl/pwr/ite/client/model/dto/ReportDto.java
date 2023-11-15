package pl.pwr.ite.client.model.dto;

import lombok.Data;

@Data
public class ReportDto {

    private RegistrationDto registration;

    private UserDto user;

    private String description;
}
