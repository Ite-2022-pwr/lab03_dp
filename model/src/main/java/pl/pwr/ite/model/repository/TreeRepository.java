package pl.pwr.ite.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pwr.ite.model.entity.Tree;

import java.util.Collection;
import java.util.UUID;

public interface TreeRepository extends JpaRepository<Tree, UUID> {

    Collection<Tree> getAllByRegistrationId(UUID registrationId);
}
