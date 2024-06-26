package com.example.btsApplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.btsApplication.entity.LineStaion;
import com.example.btsApplication.model.LineStaionModel;
import com.example.btsApplication.repository.LineStationRepository;

@Service
public class LineStationService {
	private final LineStationRepository lineStationRepository;
   
    public LineStationService(LineStationRepository lineStationRepository) {
        this.lineStationRepository = lineStationRepository;
    }

    @Transactional(readOnly = true)
    public Optional<LineStaionModel> findById(Long id) {
        Optional<LineStaion> lineStaion = lineStationRepository.findById(id);
        return lineStaion.map(LineStaionModel::convertToModel);
    }
    
    @Transactional(readOnly = true)
    public List<LineStaionModel> getAllLineStations() {
        List<LineStaion> lineStaions = lineStationRepository.findAll();
        return lineStaions.stream()
                          .map(LineStaionModel::convertToModel)
                          .collect(Collectors.toList());
    }
 
    
}
