package com.example.btsApplication.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.btsApplication.model.LineStaionModel;
import com.example.btsApplication.service.LineStationService;

@RestController
@RequestMapping("/api/lineStations")
public class LineStationController {

    private final LineStationService lineStationService;

    public LineStationController(LineStationService lineStationService) {
        this.lineStationService = lineStationService;
    }

    @GetMapping("lineStation/{id}")
    public ResponseEntity<LineStaionModel> getLineStationById(@PathVariable Long id) {
        Optional<LineStaionModel> lineStaionModelOptional = lineStationService.findById(id);
        return lineStaionModelOptional.map(ResponseEntity::ok)
                                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
