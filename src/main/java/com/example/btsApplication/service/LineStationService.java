package com.example.btsApplication.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.example.btsApplication.entity.LineStaion;
import com.example.btsApplication.model.LineStaionModel;
import com.example.btsApplication.repository.LineStationRepository;

@Service
public class LineStationService {
	private final LineStationRepository lineStationRepository;
   
    public LineStationService(LineStationRepository lineStationRepository) {
        this.lineStationRepository = lineStationRepository;
    }

    public Optional<LineStaionModel> findById(Long id) {
        Optional<LineStaion> lineStaionOptional = lineStationRepository.findById(id);
        return lineStaionOptional.map(LineStationService::convertToModel);
    }
 
     public static  LineStaionModel convertToModel(LineStaion lineStaion){
        LineStaionModel lineStaionModel = new LineStaionModel();
        lineStaionModel.setColor(lineStaion.getColor());
        lineStaionModel.setId(lineStaion.getId());
        lineStaionModel.setLineStationNameENG(lineStaion.getLineStationNameENG());
        lineStaionModel.setLineStationNameTH(lineStaion.getLineStationNameTH());
        lineStaionModel.setCreatedDay(lineStaion.getCreatedDay());
        lineStaionModel.setUpdatedDay(lineStaion.getUpdatedDay());
       return lineStaionModel;
    }

}
