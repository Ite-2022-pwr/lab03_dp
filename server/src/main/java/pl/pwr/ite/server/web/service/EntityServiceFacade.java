package pl.pwr.ite.server.web.service;

import pl.pwr.ite.server.model.entity.EntityBase;
import pl.pwr.ite.server.web.mapper.MapperBase;
import pl.pwr.ite.server.service.EntityService;

import java.util.Collection;
import java.util.UUID;

public abstract class EntityServiceFacade<E extends EntityBase, D, S extends EntityService<E>, M extends MapperBase<E, D>> {

    private final S service;

    private final M mapper;

    protected EntityServiceFacade(S service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public S getService() {
        return service;
    }

    public E getById(UUID id) {
        return service.findById(id);
    }

    public D getDtoById(UUID id) {
        return mapper.map(getById(id));
    }

    public E saveAndFlush(E entity) {
        return service.saveAndFlush(entity);
    }

    public E save(E entity) {
        return service.save(entity);
    }

    public D map(E entity) {
        return mapper.map(entity);
    }

    public Collection<D> map(Collection<E> entities) {
        return mapper.map(entities);
    }
}
