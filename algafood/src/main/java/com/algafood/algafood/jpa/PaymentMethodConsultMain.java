package com.algafood.algafood.jpa;

import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.PaymentMethod;
import com.algafood.algafood.domain.repository.PaymentMethodRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class PaymentMethodConsultMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        PaymentMethodRepository paymentMethodRepository = applicationContext.getBean(PaymentMethodRepository.class);

        // LIST ALL PAYMENT METHODS

        List<PaymentMethod> paymentMethods = paymentMethodRepository.listAll();
        for (PaymentMethod paymentMethod : paymentMethods){
            System.out.println(paymentMethod.getDescription());
        }

        //SET A NEW PAYMENT METHOD

//        PaymentMethod paymentMethod = new PaymentMethod();
//        paymentMethod.setId(1L);
//        paymentMethod.setDescription("credito");
//        paymentMethodRepository.save(paymentMethod);

        //FIND BY ID

//          PaymentMethod paymentMethod = paymentMethodRepository.findById(2L);
//          System.out.println(paymentMethod.getDescription());


        //INCLUDE A NEW PAYMENT METHOD

//        PaymentMethod paymentMethod1 = new PaymentMethod();
//        paymentMethod1.setDescription("escambo");
//        PaymentMethod paymentMethod2 = new PaymentMethod();
//        paymentMethod2.setDescription("bala");
//
//        paymentMethod1 = paymentMethodRepository.save(paymentMethod1);
//        paymentMethod2 = paymentMethodRepository.save(paymentMethod2);
//
//        System.out.printf("%d - %s\n", paymentMethod1.getId(), paymentMethod1.getDescription());
//        System.out.printf("%d - %s\n", paymentMethod2.getId(), paymentMethod2.getDescription());

    }
}
