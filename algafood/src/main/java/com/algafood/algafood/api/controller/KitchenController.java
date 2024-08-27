package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.KitchenRepository;
import com.algafood.algafood.domain.service.CadKitchenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kitchens")
public class KitchenController {

    private final KitchenRepository kitchenRepository;
    private final CadKitchenService cadKitchen;

    @GetMapping
    public List<Kitchen> listAll(){
        return kitchenRepository.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable Long id){
        Kitchen kitchen = kitchenRepository.findById(id);
        if (kitchen != null){
            return ResponseEntity.ok(kitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen save(@RequestBody Kitchen kitchen){
        return cadKitchen.save(kitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> att(@PathVariable Long id,
                                       @RequestBody Kitchen kitchen){

        Kitchen actualKitchen = kitchenRepository.findById(id);
        if (actualKitchen != null){
            BeanUtils.copyProperties(kitchen, actualKitchen, "id");
            actualKitchen = cadKitchen.save(actualKitchen);
            return ResponseEntity.ok(actualKitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long id){
        try {
            cadKitchen.remove(id);
            return ResponseEntity.noContent().build();
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (UseEntityException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
