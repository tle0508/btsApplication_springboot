package com.example.btsApplication.repository;

import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.model.PriceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PriceRepository  extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findById(Long id);

    @Query("SELECT p.price FROM PriceEntity p WHERE p.numOfDistance = :numOfDistance")
    Integer getPriceByDistance(@Param("numOfDistance") Integer numOfDistance);
}
