package com.example.btsApplication.repository;

import com.example.btsApplication.entity.BtsStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BtsRepository extends JpaRepository<BtsStation, Long> {
    List<BtsStation> findByLineColorAndIsActivate(String lineColor, boolean isActivate);
}
