package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    List<PaymentMethod> listAll();
    PaymentMethod save(PaymentMethod paymentMethod);
    PaymentMethod findById(Long id);
    void remove(PaymentMethod paymentMethod);

}
