package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.Permission;
import com.algafood.algafood.domain.repository.PermissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionImpl implements PermissionRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Permission> listAll() {
        return manager.createQuery("from Permission", Permission.class).getResultList();
    }

    @Override
    @Transactional
    public Permission save(Permission permission) {
        return manager.merge(permission);
    }

    @Override
    public Permission findById(Long id) {
        return manager.find(Permission.class, id);
    }

    @Override
    @Transactional
    public void remove(Permission permission) {
        permission = findById(permission.getId());
        manager.remove(permission);
    }
}
