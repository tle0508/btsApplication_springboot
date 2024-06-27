package com.example.btsApplication.service;

import com.example.btsApplication.entity.Price;
import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.repository.PriceRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

  
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    public PriceModel updatePrice(Long numOfDistance, int price) {
        Optional<Price> priceEntity = priceRepository.findByNumOfDistance(numOfDistance);
        if(price < 100 && price >= 0){
            if (priceEntity.isPresent()) {
                Price updatePriceEntity = priceEntity.get();
                updatePriceEntity.setPrice(price);
                updatePriceEntity.setUpdatedDay(LocalDateTime.now());
                return PriceModel.convertToModel(priceRepository.save(updatePriceEntity));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"entity not exist");
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect price");
    }

    @Transactional(readOnly = true)
    public List<PriceModel> getAllPrices() {
        List<Price> priceEntities = priceRepository.findAll();
        return priceEntities.stream()
                .map(PriceModel::convertToModel)
                .collect(Collectors.toList());
    }

}
