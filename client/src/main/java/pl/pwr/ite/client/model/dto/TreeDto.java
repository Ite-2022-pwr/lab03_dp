package pl.pwr.ite.client.model.dto;

import lombok.Data;

@Data
public class TreeDto {

    private RegistrationDto registration;

    private String name;

    private Double diameter;
}
