package com.example.btsApplication.controller;

import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.service.BtsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bts")
public class BtsController {
    private final BtsService btsService;

    public BtsController(BtsService btsService) {
        this.btsService = btsService;
    }

    @GetMapping("/LineStation/{lineStationId}")
    public ResponseEntity<List<BtsModel>> getBtsStationsByLineStationId(@PathVariable Long lineStationId) {
        List<BtsModel> btsModels = btsService.getStationByLineStationID(lineStationId,true);
        return ResponseEntity.ok(btsModels);
    }
}
