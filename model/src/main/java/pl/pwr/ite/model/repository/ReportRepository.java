package pl.pwr.ite.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.ite.model.entity.Report;

import java.util.Optional;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {

    Optional<Report> findByRegistrationId(UUID registrationId);
}
