package com.example.btsApplication.service;

import com.example.btsApplication.entity.BtsStation;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.repository.BtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BtsService {
    private final BtsRepository btsRepository;
    @Autowired
    public BtsService(BtsRepository btsRepository) {
        this.btsRepository = btsRepository;
    }
    public List<BtsModel> findByLineColor(String lineColor,boolean isActivate) {
        List<BtsStation> btsEntities = btsRepository.findByLineColorAndIsActivate(lineColor, isActivate);
        List<BtsModel> btsModels = btsEntities.stream()
                .map(BtsService::convertToModel)
                .collect(Collectors.toList());
        return btsModels;
    }
    public BtsModel findById(Long id) {
        Optional<BtsStation> btsEntity = btsRepository.findById(id);
        return btsEntity.map(BtsService::convertToModel).orElse(null);
    }

    public static  BtsModel convertToModel(BtsStation btsEntity){
        BtsModel btsModel = new BtsModel();
        btsModel.setId(btsEntity.getId());
        btsModel.setActivate(btsEntity.getActivate());
        btsModel.setBtsStationNameENG(btsEntity.getBtsStationNameENG());
        btsModel.setBtsStationNameTH(btsEntity.getBtsStationNameTH());
        btsModel.setCreatedDay(btsEntity.getCreatedDay());
        btsModel.setExtension(btsEntity.getExtension());
        btsModel.setUpdatedDay(btsEntity.getUpdatedDay());
        btsModel.setLineColor(btsEntity.getLineColor());
        btsModel.setIdStation(btsEntity.getIdStation());
       return btsModel;
    }
}
