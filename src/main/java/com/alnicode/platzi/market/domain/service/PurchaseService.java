package com.alnicode.platzi.market.domain.service;

import com.alnicode.platzi.market.domain.Purchase;
import com.alnicode.platzi.market.persistence.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Purchase> getAll() {
        return this.compraRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return this.compraRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return this.compraRepository.save(purchase);
    }
}
