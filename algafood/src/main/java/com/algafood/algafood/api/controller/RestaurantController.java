package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.RestaurantRepository;
import com.algafood.algafood.domain.service.CadRestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final CadRestaurantService cadRestaurant;

    @GetMapping
    public List<Restaurant> listAll(){
        return restaurantRepository.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id){
        Restaurant restaurant = restaurantRepository.findById(id);
        if (restaurant != null){
            return ResponseEntity.ok(restaurant);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Restaurant restaurant){
        try {
            restaurant = cadRestaurant.save(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurant);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                          @RequestBody Restaurant restaurant){

        Restaurant actualRestaurant = restaurantRepository.findById(id);
        try {
            if (actualRestaurant != null){
                BeanUtils.copyProperties(restaurant, actualRestaurant, "id");
                actualRestaurant = cadRestaurant.save(actualRestaurant);
                return ResponseEntity.ok(actualRestaurant);
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.notFound().build();
    }


}
