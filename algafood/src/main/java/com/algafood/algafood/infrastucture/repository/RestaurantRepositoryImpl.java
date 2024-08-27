package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {
    @PersistenceContext
    public EntityManager manager;

    @Override
    public List<Restaurant> listAll() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public void remove(Restaurant restaurant) {
        restaurant = findById(restaurant.getId());
        manager.remove(restaurant);
    }
}
