package com.example.btsApplication.controller;

import com.example.btsApplication.model.PriceExtensionModel;
import com.example.btsApplication.service.PriceExtensionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricesExtension")
public class PriceExtensionController {

    private final PriceExtensionService priceExtensionService;

    public PriceExtensionController(PriceExtensionService priceExtensionService) {
        this.priceExtensionService = priceExtensionService;
    }

  
    @PutMapping("/{numOfDistance}")
    public ResponseEntity<PriceExtensionModel> updatePrice(@PathVariable Long numOfDistance, @RequestParam Integer price) {
        PriceExtensionModel priceModel = priceExtensionService.updatePrice(numOfDistance, price);
            return new ResponseEntity<>(priceModel, HttpStatus.OK);      
    }
 

    @GetMapping("getAllPrices")
    public ResponseEntity<List<PriceExtensionModel>> getAllPrices() {
        List<PriceExtensionModel> prices = priceExtensionService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
