package com.xml.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "fuelType")
    private Set<Car> cars;
}
