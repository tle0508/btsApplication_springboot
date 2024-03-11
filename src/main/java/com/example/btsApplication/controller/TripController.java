package com.example.btsApplication.controller;

import com.example.btsApplication.model.TripResultModel;
import com.example.btsApplication.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
@CrossOrigin(origins = "http://localhost:4200")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/calculatePrice/{startStationId}/{endStationId}")
    public TripResultModel calculateTripPrice(
            @PathVariable("startStationId") Long startStationId,
            @PathVariable("endStationId") Long endStationId
    ) {
        return tripService.calculateTripPrice(startStationId, endStationId);
    }
}
