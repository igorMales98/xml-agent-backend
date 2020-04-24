package com.xml.model;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name = "users")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(insertable = false, updatable = false)
    protected String type;

    @Column(nullable = false, unique = true)
    protected String username;

    @Column(nullable = false)
    protected String password;

    @Column()
    protected String firstName;

    @Column()
    protected String lastName;

    @Column(nullable = false)
    protected String country;

    @Column(nullable = false)
    protected String city;

    @Column(nullable = false)
    protected String address;

    @Column(nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String phone;

    @Column
    protected boolean enabled;


}
