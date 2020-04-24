package com.xml.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;



@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_brand_id", nullable = false)
    private CarBrand carBrand;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "transmission_type_id", nullable = false)
    private TransmissionType transmissionType;

    @ManyToOne
    @JoinColumn(name = "car_class_id", nullable = false)
    private CarClass carClass;

    @Column(nullable = false)
    @Range(min = 0, max = 1000000)
    private float mileage;

    @Column(nullable = false)
    private float allowedDistance = 1000000;

    @Column(nullable = false)
    private boolean collisionDamageWaiverExists = false;

    @Column(nullable = false)
    @Range(min = 0, max = 9)
    private int childSeats = 0;

    @Column
    private int timesRated = 0;

    @Column
    private float averageRating = 0;

    @Column
    private boolean hasAndroid = false;

}
