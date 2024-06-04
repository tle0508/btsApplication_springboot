package com.example.btsApplication.controller;

import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("getTripsByStartAndEndStationId/{startStationId}/{endStationId}")
    public ResponseEntity<List<TripModel>> getTripsByStartAndEndStationId(
            @RequestParam Long startStationId,
            @RequestParam Long endStationId) {
        List<TripModel> trips = tripService.getTripsByStartAndEndStationId(startStationId, endStationId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

}
