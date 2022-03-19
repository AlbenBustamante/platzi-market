package com.alnicode.platzi.market.persistence;

import com.alnicode.platzi.market.domain.Purchase;
import com.alnicode.platzi.market.domain.repository.PurchaseRepository;
import com.alnicode.platzi.market.persistence.crud.CompraCrudRepository;
import com.alnicode.platzi.market.persistence.entity.Compra;
import com.alnicode.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) this.compraCrudRepository.findAll();
        return this.mapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        List<Compra> compras = this.compraCrudRepository.findByIdCliente(clientId);
        return Optional.of(this.mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = this.mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return this.mapper.toPurchase(this.compraCrudRepository.save(compra));
    }
}
