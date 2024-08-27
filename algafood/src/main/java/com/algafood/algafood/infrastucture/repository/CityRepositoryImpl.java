package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.City;
import com.algafood.algafood.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<City> listAll() {
        return manager.createQuery("from City ", City.class).getResultList();
    }

    @Override
    @Transactional
    public City save(City city) {
        return manager.merge(city);
    }

    @Override
    public City findById(Long id) {
        return manager.find(City.class, id);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        City city = findById(id);
        manager.remove(city);
    }
}
