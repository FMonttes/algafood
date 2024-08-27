package com.algafood.algafood.jpa;

import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class KitchenConsultMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

        //CONSULT WHAT HAVE ON THE TABLE

        List<Kitchen> kitchens = kitchenRepository.list();
        for (Kitchen kitchen : kitchens){
            System.out.println(kitchen.getName());
        }

        //SET A NEW DATA IN A ID THAT ALREADY EXISTS

//        Kitchen kitchen = new Kitchen();
//        kitchen.setId(1L);
//        kitchen.setName("Brazilian");
//
//        kitchenRepository.save(kitchen);

        //DELETE A KITCHEN BASED ON AN ID

//        Kitchen kitchen = new Kitchen();
//        kitchen.setId(1L);
//        kitchenRepository.remove(kitchen);

        //FIND A KITCHEN BY ID

//        Kitchen kitchens = kitchenRepository.findById(1L);
//        System.out.println(kitchens.getName());

        //INCLUDE A NEW KITCHEN

//        Kitchen kitchen1 = new Kitchen();
//        kitchen1.setName("brazilian");
//        Kitchen kitchen2 = new Kitchen();
//        kitchen2.setName("japanese");
//
//        kitchen1 = kitchenRepository.save(kitchen1);
//        kitchen2 = kitchenRepository.save(kitchen2);
//
//        System.out.printf("%d - %s\n", kitchen1.getId(), kitchen1.getName());
//        System.out.printf("%d - %s\n", kitchen2.getId(), kitchen2.getName());

    }
}
 