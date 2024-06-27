package com.example.btsApplication.controller;

import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.service.TripService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
@RequestMapping("/api/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/TripsByStartAndEndStationId/{startStationId}/{endStationId}")
    public ResponseEntity<TripModel> getTripsByStartAndEndStationId(
            @PathVariable Long startStationId,
            @PathVariable Long endStationId) {
        Optional<TripModel> trips = tripService.getTripsByStartAndEndStationId(startStationId, endStationId);
        
        return trips.map(ResponseEntity::ok)
                                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
