package com.xml.model;

import javax.persistence.*;

@Entity
public class Pricelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Float pricePerDay;

    @Column
    private Float pricePerKm;

    @Column
    private Float priceForCDW;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Float getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(Float pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public Float getPriceForCDW() {
        return priceForCDW;
    }

    public void setPriceForCDW(Float priceForCDW) {
        this.priceForCDW = priceForCDW;
    }

}
