package pl.pwr.ite.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pwr.ite.model.entity.Registration;
import pl.pwr.ite.model.enums.RegistrationStatus;

import java.util.Collection;
import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

    @Query("SELECT r FROM Registration r WHERE r.userId = ?1")
    Collection<Registration> getAllByUserId(UUID userId);

    @Query("SELECT r FROM Registration r WHERE r.status IN (?1)")
    Collection<Registration> getAllWithStatus(Collection<RegistrationStatus> statuses);

    @Query("SELECT r FROM Registration r WHERE r.userId = ?1 AND r.status IN (?2)")
    Collection<Registration> getList(UUID userId, Collection<RegistrationStatus> statuses);
}
