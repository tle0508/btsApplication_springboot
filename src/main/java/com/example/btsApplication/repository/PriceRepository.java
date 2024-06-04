package com.example.btsApplication.repository;

import com.example.btsApplication.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository  extends JpaRepository<Price, Long> {
    Optional<Price> findByNumOfDistance(Long numOfDistance);
    
}
