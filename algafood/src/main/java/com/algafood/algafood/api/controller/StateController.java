package com.algafood.algafood.api.controller;

import com.algafood.algafood.api.model.StateXmlWrapper;
import com.algafood.algafood.domain.exception.EntityNotFoundException;
import com.algafood.algafood.domain.exception.UseEntityException;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.State;
import com.algafood.algafood.domain.repository.StateRepository;
import com.algafood.algafood.domain.service.CadStateService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/states")
public class StateController {

    private final  StateRepository stateRepository;
    private final CadStateService cadState;

    @GetMapping
    public List<State> listAll(){
        return stateRepository.listAll();
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<State> findById(@PathVariable Long stateId){
        State state = stateRepository.findById(stateId);
        if (state != null){
            return ResponseEntity.ok(state);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State save(@RequestBody State state){
        return cadState.save(state);
    }

    @PutMapping("/{stateId}")
    public ResponseEntity<State> att(@PathVariable Long stateId,
                                     @RequestBody State state){

        State ActuallyState = stateRepository.findById(stateId);
        if (ActuallyState != null) {
            BeanUtils.copyProperties(state, ActuallyState, "id");
            ActuallyState = cadState.save(ActuallyState);
            return ResponseEntity.ok(ActuallyState);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{stateId}")
    public ResponseEntity<State> delete(@PathVariable Long stateId){
        try {
            cadState.remove(stateId);
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
