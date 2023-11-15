package pl.pwr.ite.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.ite.model.entity.EntityBase;

import java.util.UUID;

public interface EntityService<E extends EntityBase> {
    E save(E entity);
    E saveAndFlush(E entity);
    E findById(UUID id);
}
