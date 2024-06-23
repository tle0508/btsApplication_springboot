package com.example.btsApplication.controller;

import com.example.btsApplication.model.PriceModel;
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

  //
    @PutMapping("/{numOfDistance}/{price}")
    public ResponseEntity<PriceModel> updatePrice(@PathVariable Long numOfDistance, @PathVariable Integer price) {
        PriceModel priceModel = priceExtensionService.updatePrice(numOfDistance, price);
            return new ResponseEntity<>(priceModel, HttpStatus.OK);      
    }
 

    @GetMapping("AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceExtensionService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
