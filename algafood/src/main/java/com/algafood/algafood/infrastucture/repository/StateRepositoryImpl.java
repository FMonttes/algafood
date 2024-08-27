package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.State;
import com.algafood.algafood.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<State> listAll() {
        return manager.createQuery("from State ", State.class).getResultList();
    }

    @Override
    @Transactional
    public State save(State state) {
        return manager.merge(state);
    }

    @Override
    public State findById(Long id) {
        return manager.find(State.class, id);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        State state = findById(id);
        if (state == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(state);
    }
}
