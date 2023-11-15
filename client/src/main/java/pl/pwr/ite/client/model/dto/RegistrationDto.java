package pl.pwr.ite.client.model.dto;

import lombok.Data;
import pl.pwr.ite.client.model.enums.RegistrationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RegistrationDto {

    private UUID id;

    private RegistrationStatus status;

    private UserDto user;

    private LocalDateTime time;

    private TreeDto[] trees;

    private ReportDto[] reports;

    private DecisionDto[] decisions;

}

