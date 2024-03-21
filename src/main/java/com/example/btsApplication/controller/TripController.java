package com.example.btsApplication.controller;

import com.example.btsApplication.entity.TripEntity;
import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
@CrossOrigin(origins = "http://localhost:4200")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("findTripsByStartAndEndStationNormalType/{startStationId}/{endStationId}")
    public ResponseEntity<List<TripModel>> findTripsByStartAndEndStationNormalType(
            @RequestParam Long startStationId,
            @RequestParam Long endStationId) {
        List<TripModel> trips = tripService.findTripsByStartAndEndStationNormalType(startStationId, endStationId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
    @GetMapping("findTripsByStartAndEndStationSpecialType/{startStationId}/{endStationId}")
    public ResponseEntity<List<TripModel>> findTripsByStartAndEndStationSpecialType(
            @RequestParam Long startStationId,
            @RequestParam Long endStationId) {
        List<TripModel> trips = tripService.findTripsByStartAndEndStationSpecialType(startStationId, endStationId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
