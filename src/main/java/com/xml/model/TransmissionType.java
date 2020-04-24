package com.xml.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TransmissionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "transmissionType")
    private Set<Car> cars;
}
