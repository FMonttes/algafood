package com.algafood.algafood.api.controller;


import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.City;
import com.algafood.algafood.domain.repository.CityRepository;
import com.algafood.algafood.domain.service.CadCityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityRepository cityRepository;
    private final CadCityService cadCity;

    @GetMapping
    public List<City> listAll(){
        return cityRepository.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){

        City city = cityRepository.findById(id);
        if (city != null){
            return ResponseEntity.ok(city);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody City city){
        try {
            city = cadCity.save(city);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(city);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody City city) {

        City actualCity = cityRepository.findById(id);
        try {
            if (actualCity != null) {
                BeanUtils.copyProperties(city, actualCity, "id");
                actualCity = cadCity.save(actualCity);
                return ResponseEntity.ok(actualCity);
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> remove(@PathVariable Long id){
        try {
            cadCity.remove(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        catch (UseEntityException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
















