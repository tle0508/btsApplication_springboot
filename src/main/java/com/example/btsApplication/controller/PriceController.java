package com.example.btsApplication.controller;

import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

   
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

   //
    @PutMapping("/{numOfDistance}/{price}")
    public ResponseEntity<PriceModel> updatePrice(@PathVariable Long numOfDistance, @PathVariable Integer price) {
        PriceModel priceModel = priceService.updatePrice(numOfDistance, price);     
            return new ResponseEntity<>(priceModel, HttpStatus.OK);   
    }

    @GetMapping("AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
