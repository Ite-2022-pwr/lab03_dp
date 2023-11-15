package pl.pwr.ite.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.ite.model.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByName(String name);
}
