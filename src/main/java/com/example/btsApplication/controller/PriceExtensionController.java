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

    //
     @PutMapping("/update/{numOfDistance}")
    public PriceModel updatePrice(
            @PathVariable Long numOfDistance,
            @RequestParam int price
    ) {
        try {
            return priceExtensionService.updatePrice(numOfDistance, price);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }
 

    @GetMapping("AllPrices")
    public ResponseEntity<List<PriceModel>> getAllPrices() {
        List<PriceModel> prices = priceExtensionService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
