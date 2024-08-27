package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.KitchenRepository;
import com.algafood.algafood.domain.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final KitchenRepository kitchenRepository;

    public Restaurant save(Restaurant restaurant){
        Long kitchenId = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.findById(kitchenId);
        if (kitchen == null){
            throw new EntityNotFoundException(
                    String.format("there's no kitchen code %d", kitchenId)
            );
        }
        restaurant.setKitchen(kitchen);
        return restaurantRepository.save(restaurant);
    }
}
