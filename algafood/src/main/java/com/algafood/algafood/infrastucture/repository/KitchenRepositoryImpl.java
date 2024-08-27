package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> list(){
        return manager.createQuery("from Kitchen", Kitchen.class)
                .getResultList();
    }
    @Transactional
    @Override
    public Kitchen save(Kitchen kitchen){
        return manager.merge(kitchen);
    }
    @Override
    public Kitchen findById(Long id){
        return manager.find(Kitchen.class, id);
    }
    @Override
    @Transactional
    public void remove(Long id){
        Kitchen kitchen = findById(id);
        if (kitchen == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(kitchen);
    }
}
