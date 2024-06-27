package com.example.btsApplication.controller;

import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

   
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

   //
    @PutMapping("/{numOfDistance}")
    public PriceModel updatePrice(@PathVariable Long numOfDistance,@RequestParam int price) {
        try {
            return priceService.updatePrice(numOfDistance, price);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }
    

    @GetMapping("/AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
