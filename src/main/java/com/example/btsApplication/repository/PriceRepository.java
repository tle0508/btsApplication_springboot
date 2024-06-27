package com.example.btsApplication.repository;

import com.example.btsApplication.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository  extends JpaRepository<Price,Long> {
  
}
