package com.example.btsApplication.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "trip_extension")
public class TripExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "START_STATION_ID")
    private BtsStation startStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "END_STATION_ID")
    private BtsStation endStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTANCE")
    private PriceExtension priceExtension;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BtsStation getStartStation() {
        return startStation;
    }
    public void setStartStation(BtsStation startStation) {
        this.startStation = startStation;
    }
    public BtsStation getEndStation() {
        return endStation;
    }
    public void setEndStation(BtsStation endStation) {
        this.endStation = endStation;
    }
	public PriceExtension getPriceExtension() {
		return priceExtension;
	}
	public void setPriceExtension(PriceExtension priceExtension) {
		this.priceExtension = priceExtension;
	}
	
	
  
}
