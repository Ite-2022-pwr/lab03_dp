package pl.pwr.ite.server.web.dto;

import lombok.Data;

@Data
public class ReportDto {

    private RegistrationDto registration;

    private String description;
}
