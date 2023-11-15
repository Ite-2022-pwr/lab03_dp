package pl.pwr.ite.client.model.filter;

import lombok.Data;
import pl.pwr.ite.client.model.enums.RegistrationStatus;

import java.util.UUID;

@Data
public class RegistrationFilter {

    private UUID userId;
    private RegistrationStatus[] statuses;
}
