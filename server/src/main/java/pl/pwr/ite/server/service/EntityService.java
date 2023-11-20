package pl.pwr.ite.server.service;

import pl.pwr.ite.server.model.entity.EntityBase;

import java.util.UUID;

public interface EntityService<E extends EntityBase> {
    E save(E entity);
    E saveAndFlush(E entity);
    E findById(UUID id);
}
