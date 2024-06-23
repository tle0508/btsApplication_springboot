package com.example.btsApplication.controller;

import com.example.btsApplication.model.TripExtensionModel;
import com.example.btsApplication.service.TripExtensionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tripExtension")
public class TripExtensionController {

    private final TripExtensionService tripExtensiopnService;

    public TripExtensionController(TripExtensionService tripExtensiopnService) {
        this.tripExtensiopnService = tripExtensiopnService;
    }

    @GetMapping("TripsByStartAndEndStationId/{startStationId}/{endStationId}")
    public ResponseEntity<List<TripExtensionModel>> getTripsByStartAndEndStationId(
            @PathVariable Long startStationId,
            @PathVariable Long endStationId) {
        List<TripExtensionModel> trips = tripExtensiopnService.getTripsByStartAndEndStationId(startStationId, endStationId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

}
