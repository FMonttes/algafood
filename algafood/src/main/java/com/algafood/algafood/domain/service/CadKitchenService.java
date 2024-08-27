package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.KitchenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadKitchenService {

    public final KitchenRepository kitchenRepository;

    public Kitchen save(Kitchen kitchen){
        return kitchenRepository.save(kitchen);
    }

    public void remove(Long id){
        try {
            kitchenRepository.remove(id);
        }
        catch (EntityNotFoundException e){
            throw new EntityNotFoundException(
                    String.format("there's no kitchen code of number %d ", id)
            );
        }
        catch (UseEntityException e){
            throw new UseEntityException(
                    String.format("State of code %d cannot be removed, because is in use", id)
            );
        }
    }

}
