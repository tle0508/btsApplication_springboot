package com.example.btsApplication.controller;

import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.service.BtsService;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getStationByLineColor/{lineColor}")
    public ResponseEntity<List<BtsModel>> getStationByLineColor(@PathVariable String lineColor) {
        List<BtsModel> models = btsService.getStationByLineColor(lineColor,true);
            return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
