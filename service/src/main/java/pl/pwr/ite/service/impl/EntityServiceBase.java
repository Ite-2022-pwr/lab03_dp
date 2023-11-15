package pl.pwr.ite.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.ite.model.entity.EntityBase;
import pl.pwr.ite.service.EntityService;

import java.util.UUID;

public abstract class EntityServiceBase<E extends EntityBase> implements EntityService<E> {

    private final JpaRepository<E, UUID> repository;

    public EntityServiceBase(JpaRepository<E, UUID> repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public E saveAndFlush(E entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public E findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public JpaRepository<E, UUID> getRepository() {
        return repository;
    }
}
