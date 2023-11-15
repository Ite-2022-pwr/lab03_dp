package pl.pwr.ite.model.filter;

import lombok.Data;
import pl.pwr.ite.model.enums.RegistrationStatus;

import java.util.UUID;

@Data
public class DecisionFilter {

    private UUID registrationId;
}
