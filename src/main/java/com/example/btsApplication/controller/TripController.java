package com.example.btsApplication.controller;

import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.service.TripService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("getTripsByStartAndEndStationId/{startStationId}/{endStationId}")
    public ResponseEntity<List<TripModel>> getTripsByStartAndEndStationId(
            @PathVariable Long startStationId,
            @PathVariable Long endStationId) {
        List<TripModel> trips = tripService.getTripsByStartAndEndStationId(startStationId, endStationId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
