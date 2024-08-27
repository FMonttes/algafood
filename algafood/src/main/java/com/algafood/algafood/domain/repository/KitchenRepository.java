package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface KitchenRepository {

    List<Kitchen> list();
    Kitchen findById(Long id);
    Kitchen save(Kitchen kitchen);
    void remove(Long id);
}
