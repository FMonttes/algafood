package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.State;
import com.algafood.algafood.domain.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadStateService {

    private final StateRepository stateRepository;

    public State save (State state){
        return stateRepository.save(state);
    }

    public void remove(Long id){
        try {
            stateRepository.remove(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException(
                    String.format("there's no State code of number %d ", id));
        }
        catch (DataIntegrityViolationException e){
            throw new UseEntityException(
                    String.format("State of code %d cannot be removed, because is in use", id));
        }
    }
}
