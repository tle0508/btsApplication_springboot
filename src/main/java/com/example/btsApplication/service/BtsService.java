package com.example.btsApplication.service;

import com.example.btsApplication.entity.BtsEntity;
import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.repository.BtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BtsService {
    private final  BtsRepository btsRepository;
    @Autowired
    public BtsService(BtsRepository btsRepository) {
        this.btsRepository = btsRepository;
    }
    public List<BtsModel> findByLineColor(String lineColor,boolean isActivate) {
        List<BtsEntity> btsEntities = btsRepository.findByLineColorAndIsActivate(lineColor, isActivate);
        List<BtsModel> btsModels = btsEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return btsModels;
    }
    public BtsModel findById(Long id) {
        Optional<BtsEntity> btsEntity = btsRepository.findById(id);
        return btsEntity.map(this::convertToModel).orElse(null);
    }
    public List<BtsModel> getAll() {
        List<BtsEntity> btsEntities = btsRepository.findAll();
        List<BtsModel> btsModels = btsEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return btsModels;
    }
    private BtsModel convertToModel(BtsEntity btsEntity){
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
