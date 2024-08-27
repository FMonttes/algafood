package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.Permission;

import java.util.List;

public interface PermissionRepository {

    List<Permission> listAll();
    Permission save(Permission permission);
    Permission findById(Long id);
    void remove(Permission permission);
}
