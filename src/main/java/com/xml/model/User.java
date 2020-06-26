package com.xml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;

import javax.persistence.*;

import java.util.List;

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
    protected @SQLInjectionSafe String type;

    @Column(nullable = false)
    protected @SQLInjectionSafe String username;

    @Column(nullable = false)
    protected @SQLInjectionSafe String password;

    @Column
    protected @SQLInjectionSafe String firstName;

    @Column
    protected @SQLInjectionSafe String lastName;

    @Column(nullable = false)
    protected @SQLInjectionSafe String country;

    @Column(nullable = false)
    protected @SQLInjectionSafe String city;

    @Column(nullable = false)
    protected @SQLInjectionSafe String address;

    @Column(nullable = false)
    protected @SQLInjectionSafe String email;

    @Column(nullable = false)
    protected @SQLInjectionSafe String phone;

    @Column
    protected boolean enabled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
