package com.xml.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "carBrand")
    private Set<Car> cars;

    @OneToMany(mappedBy = "carBrand")
    private Set<CarModel> carModels;
}
