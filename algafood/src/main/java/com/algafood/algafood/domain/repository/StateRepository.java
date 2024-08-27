package com.algafood.algafood.domain.repository;


import com.algafood.algafood.domain.model.State;

import java.util.List;

public interface StateRepository {

    List<State> listAll();
    State save(State state);
    State findById(Long id);
    void remove(Long id);

}
