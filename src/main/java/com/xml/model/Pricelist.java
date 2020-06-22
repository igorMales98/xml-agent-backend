package com.xml.model;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "enabled")
    private boolean enabled = true;

    @OneToMany(mappedBy = "pricelist")
    private Set<Advertisement> advertisements;

    @Column
    private Long realId;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public Long getRealId() {
        return realId;
    }

    public void setRealId(Long realId) {
        this.realId = realId;
    }
}
