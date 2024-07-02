package com.example.btsApplication.service;

import com.example.btsApplication.entity.BtsStation;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.repository.BtsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BtsService {
    private final BtsRepository btsRepository;
   
    public BtsService(BtsRepository btsRepository) {
        this.btsRepository = btsRepository;
    }
    
    @Transactional(readOnly = true)
    public List<BtsModel> getStationByLineStationID(Long lineStationId,boolean isActivate) {
        List<BtsStation> btsStations = btsRepository.findByLineStaionIdAndIsActivate(lineStationId,isActivate);
        return btsStations.stream()
                          .map(BtsModel::convertToModel)
                          .collect(Collectors.toList());
    }
    

    
  
}
