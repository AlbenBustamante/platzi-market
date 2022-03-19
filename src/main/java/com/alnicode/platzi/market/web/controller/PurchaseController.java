package com.alnicode.platzi.market.web.controller;

import com.alnicode.platzi.market.domain.Purchase;
import com.alnicode.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getPurchases() {
        return new ResponseEntity<>(this.purchaseService.getAll(), HttpStatus.OK);
    }
}
