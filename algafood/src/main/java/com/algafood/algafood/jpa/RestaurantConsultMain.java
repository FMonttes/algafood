package com.algafood.algafood.jpa;

import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.KitchenRepository;
import com.algafood.algafood.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class RestaurantConsultMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        //LIST ALL RESTAURANTS ON DATA BASE

        List<Restaurant> restaurants = restaurantRepository.listAll();
        for (Restaurant restaurant : restaurants){
            System.out.println(restaurant.getName() + " - " + restaurant.getDeliveryTax() +
                  " - " +  restaurant.getKitchen().getId());
        }

        // SET A NEW RESTAURANT ON AN ID THAT ALREADY EXISTS

//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(1L);
//        restaurant.setName("Popai");
//        restaurant.setDeliveryTax(BigDecimal.ZERO);
//
//        restaurantRepository.save(restaurant);

        //DELETE A RESTAURANT BASED ON ID

//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(1L);
//        restaurantRepository.remove(restaurant);

        //FIND A RESTAURANT BY ID

//        Restaurant restaurant = restaurantRepository.findById(1L);
//        System.out.println(restaurant.getName());

        //ADD A NEW RESTAURANT

//        Restaurant restaurant1 = new Restaurant();
//        restaurant1.setName("duBairro");
//        restaurant1.setDeliveryTax(BigDecimal.ZERO);
//        Restaurant restaurant2 = new Restaurant();
//        restaurant2.setName("tiaRo");
//        restaurant2.setDeliveryTax(BigDecimal.ZERO);
//
//        restaurant1 = restaurantRepository.save(restaurant1);
//        restaurant2 = restaurantRepository.save(restaurant2);
//
//        System.out.printf("%d - %s - %.2f\n", restaurant1.getId(), restaurant1.getName(), restaurant1.getDeliveryTax());
//        System.out.printf("%d - %s - %.2f\n", restaurant2.getId(), restaurant2.getName(), restaurant2.getDeliveryTax());
    }
}
 