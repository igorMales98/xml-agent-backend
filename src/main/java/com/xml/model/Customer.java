package com.xml.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    @Column
    @Range(min = 0, max = 3)
    private short advertisementsPosted;
}
