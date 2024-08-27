package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> listAll();
    Restaurant save(Restaurant restaurant);
    Restaurant findById(Long id);
    void remove(Restaurant restaurant);

}
