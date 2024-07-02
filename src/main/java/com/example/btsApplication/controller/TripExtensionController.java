package com.example.btsApplication.controller;


import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.service.TripExtensionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/tripExtension")
public class TripExtensionController {

    private final TripExtensionService tripExtensiopnService;

    public TripExtensionController(TripExtensionService tripExtensiopnService) {
        this.tripExtensiopnService = tripExtensiopnService;
    }

    @GetMapping("/TripsByStartAndEndStationId/{startStationId}/{endStationId}")
    public ResponseEntity<TripModel> getTripsByStartAndEndStationId(
            @PathVariable Long startStationId,
            @PathVariable Long endStationId) {
        Optional<TripModel> trips = tripExtensiopnService.getTripsByStartAndEndStationId(startStationId, endStationId);
        return ResponseEntity.of(trips);
    }

}
