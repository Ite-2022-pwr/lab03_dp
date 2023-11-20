package pl.pwr.ite.server.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.ite.server.model.entity.Tree;

import java.util.Collection;
import java.util.UUID;

public interface TreeRepository extends JpaRepository<Tree, UUID> {

    Collection<Tree> getAllByRegistrationId(UUID registrationId);
}
