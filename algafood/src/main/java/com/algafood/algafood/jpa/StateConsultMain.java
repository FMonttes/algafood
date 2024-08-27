package com.algafood.algafood.jpa;


import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.State;
import com.algafood.algafood.domain.repository.StateRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class StateConsultMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        StateRepository stateRepository = applicationContext.getBean(StateRepository.class);

        //LIST ALL

        List<State> states = stateRepository.listAll();
        for (State state : states){
            System.out.println(state.getName());
        }

        //REPLACE A STATE BY ID

//        State state = new State();
//        state.setId(2L);
//        state.setName("San Pablo");
//        stateRepository.save(state);

        //FIND BY ID

//        State state = stateRepository.findById(1L);
//        System.out.println(state.getName());

        //DELETE

//        State state = new State();
//        state.setId(1L);
//        stateRepository.remove(state);

        //SET A NEW STATE

//        State state = new State();
//        state.setName("Porto Alegre");
//
//        state = stateRepository.save(state);
//        System.out.println(state.getName());

    }
}
