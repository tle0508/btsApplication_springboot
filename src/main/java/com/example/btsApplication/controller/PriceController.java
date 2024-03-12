package com.example.btsApplication.controller;

import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.model.PriceModel;
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
    public ResponseEntity<PriceModel> updatePrice(@PathVariable Long id, @RequestParam Integer price) {
        PriceModel priceModel = priceService.updatePrice(id, price);
        if (priceModel != null) {
            return new ResponseEntity<>(priceModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getAllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
