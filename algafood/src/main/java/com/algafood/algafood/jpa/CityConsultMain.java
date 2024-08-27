package com.algafood.algafood.jpa;

import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.City;
import com.algafood.algafood.domain.repository.CityRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class CityConsultMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CityRepository cityRepository = applicationContext.getBean(CityRepository.class);

        //LIST ALL

        List<City> cities = cityRepository.listAll();
        for (City city : cities){
            System.out.println(city.getName() + " - " + city.getState().getName());
        }

        //REPLACE A CITY

//        City city = new City();
//        city.setId(1L);
//        city.setName("Sao Paulo");
//        cityRepository.save(city);

        //FIND BY ID

//        City city = cityRepository.findById(1L);
//        System.out.println(city.getName());

        //DELETE

//        City city = new City();
//        city.setId(2L);
//        cityRepository.remove(city);

        //UPDATE

//        City city = new City();
//        city.setName("sao paulo");
//        city = cityRepository.save(city);
//        System.out.println(city.getName());

    }
}
