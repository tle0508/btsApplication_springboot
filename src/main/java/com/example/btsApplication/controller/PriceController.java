package com.example.btsApplication.controller;

import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin(origins = "http://localhost:4200")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceEntity> updatePrice(@PathVariable Long id, @RequestParam Integer price) {
        PriceEntity updatedPriceEntity = priceService.updatePrice(id, price);

        if (updatedPriceEntity != null) {
            return new ResponseEntity<>(updatedPriceEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("getAllPrices")
    public ResponseEntity<List<PriceEntity>> getAllPrices() {
        List<PriceEntity> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
