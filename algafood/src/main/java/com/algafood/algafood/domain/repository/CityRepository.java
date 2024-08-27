package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.City;

import java.util.List;

public interface CityRepository {

    List<City> listAll();
    City save(City city);
    City findById(Long id);
    void remove(Long id);

}
