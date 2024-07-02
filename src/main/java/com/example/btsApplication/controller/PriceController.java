package com.example.btsApplication.controller;


import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

   
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PutMapping("/{id}/{price}")
    public ResponseEntity<PriceModel> updatePrice(@PathVariable Long id, @PathVariable int price) {
        try {
            PriceModel updatedPrice = priceService.updatePrice(id, price);
            return ResponseEntity.ok(updatedPrice);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }

    @GetMapping("/Price/{id}")
    public ResponseEntity<PriceModel> getPriceById(@PathVariable Long id) {
        Optional<PriceModel> price = priceService.findById(id);
        return ResponseEntity.of(price);
    }

    @GetMapping("/AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceService.getAllPrices();
        return ResponseEntity.ok(prices);
    }
}
