package pl.pwr.ite.server.model.filter;

import lombok.Data;
import pl.pwr.ite.server.model.enums.RegistrationStatus;

import java.util.UUID;

@Data
public class RegistrationFilter {

    private UUID userId;

    private RegistrationStatus[] statuses;
}
