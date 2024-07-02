package com.example.btsApplication.controller;

import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.service.PriceExtensionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/pricesExtension")
public class PriceExtensionController {

    private final PriceExtensionService priceExtensionService;

    public PriceExtensionController(PriceExtensionService priceExtensionService) {
        this.priceExtensionService = priceExtensionService;
    }

    @PutMapping("/{id}/{price}")
    public ResponseEntity<PriceModel> updatePrice(@PathVariable Long id, @PathVariable int price) {
        try {
            PriceModel updatedPrice = priceExtensionService.updatePrice(id, price);
            return ResponseEntity.ok(updatedPrice);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }
 

    @GetMapping("/AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceExtensionService.getAllPrices();
        return ResponseEntity.ok(prices);
    }
}
