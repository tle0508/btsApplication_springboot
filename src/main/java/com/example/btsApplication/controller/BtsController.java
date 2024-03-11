package com.example.btsApplication.controller;

import com.example.btsApplication.entity.BtsEntity;
import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.service.BtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bts")
@CrossOrigin(origins = "http://localhost:4200")
public class BtsController {
    private final BtsService btsService;

    @Autowired
    public BtsController(BtsService btsService) {
        this.btsService = btsService;
    }

    @GetMapping("/findByLineColor/{lineColor}")
    public ResponseEntity<List<BtsModel>> findByLineColor(@PathVariable String lineColor) {
        List<BtsModel> models = btsService.findByLineColor(lineColor,true);
        if (!models.isEmpty()) {
            return new ResponseEntity<>(models, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<BtsModel>> getAllBts() {
        List<BtsModel> models = btsService.getAll();
        if (!models.isEmpty()) {
            return new ResponseEntity<>(models, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
