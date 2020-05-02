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

    @OneToMany(mappedBy = "pricelist")
    private Set<Advertisement> advertisements;

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


// cena za km preko dozvoljnog ako nije unlimited

}
