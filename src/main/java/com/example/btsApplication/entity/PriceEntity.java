package com.example.btsApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "price_table")
    public class PriceEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "num_of_distance")
        private Integer numOfDistance;

        @Column(name = "price")
        private Integer price;

        @Column(name = "created_day", updatable = false)
        private LocalDateTime createdDay;

        @Column(name = "updated_day")
        private LocalDateTime updatedDay;
        public PriceEntity() {

        }
        public PriceEntity(Long id, Integer numOfDistance, Integer price, LocalDateTime createdDay, LocalDateTime updatedDay) {
            this.id = id;
            this.numOfDistance = numOfDistance;
            this.price = price;
            this.createdDay = createdDay;
            this.updatedDay = updatedDay;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getNumOfDistance() {
            return numOfDistance;
        }

        public void setNumOfDistance(Integer numOfDistance) {
            this.numOfDistance = numOfDistance;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public LocalDateTime getCreatedDay() {
            return createdDay;
        }

        public void setCreatedDay(LocalDateTime createdDay) {
            this.createdDay = createdDay;
        }

        public LocalDateTime getUpdatedDay() {
            return updatedDay;
        }

        public void setUpdatedDay(LocalDateTime updatedDay) {
            this.updatedDay = updatedDay;
        }
    }
