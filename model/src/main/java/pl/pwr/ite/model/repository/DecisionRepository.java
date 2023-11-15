package pl.pwr.ite.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pwr.ite.model.entity.Decision;
import pl.pwr.ite.model.enums.RegistrationStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DecisionRepository extends JpaRepository<Decision, UUID> {

    Optional<Decision> getByRegistrationId(UUID registrationId);
}
