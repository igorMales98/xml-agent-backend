package com.xml.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "advertiser_id")
    private User advertiser;

    @Column
    private LocalDateTime availableFrom;

    @Column
    private LocalDateTime availableTo;

    @OneToMany(mappedBy = "advertisement")
    private Set<Comment> comments;

}
