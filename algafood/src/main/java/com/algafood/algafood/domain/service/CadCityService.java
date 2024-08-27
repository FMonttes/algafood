package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.City;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.model.State;
import com.algafood.algafood.domain.repository.CityRepository;
import com.algafood.algafood.domain.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadCityService {

    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public City save(City city) {
        Long stateId = city.getState().getId();
        State state = stateRepository.findById(stateId);
        if (state == null) {
            throw new EntityNotFoundException(
                    String.format("There's no state with code %d", stateId)
            );
        }
        city.setState(state);
        return cityRepository.save(city);
    }



    public void remove(Long id){
        try {
            cityRepository.remove(id);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(
                    String.format("there's no city code of number %d", id)
            );
        }catch (UseEntityException e){
            throw new UseEntityException(
                    String.format("city of code %d cannot be removed, because is in use", id)
            );
        }
    }
}
