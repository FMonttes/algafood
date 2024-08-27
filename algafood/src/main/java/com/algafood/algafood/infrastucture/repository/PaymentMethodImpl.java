package com.algafood.algafood.infrastucture.repository;

import com.algafood.algafood.domain.model.PaymentMethod;
import com.algafood.algafood.domain.repository.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMethodImpl implements PaymentMethodRepository{

    @PersistenceContext
    public EntityManager manager;


    @Override
    public List<PaymentMethod> listAll() {
        return manager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
    }

    @Override
    @Transactional
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Override
    public PaymentMethod findById(Long id) {
        return manager.find(PaymentMethod.class, id);
    }

    @Override
    @Transactional
    public void remove(PaymentMethod paymentMethod) {
        paymentMethod = findById(paymentMethod.getId());
        manager.remove(paymentMethod);
    }
}
