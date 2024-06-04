package com.example.btsApplication.repository;


import com.example.btsApplication.entity.PriceExtension;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceExtensionRepository  extends JpaRepository<PriceExtension, Long> {
    Optional<PriceExtension> findByNumOfDistance(Long numOfDistance);
}
