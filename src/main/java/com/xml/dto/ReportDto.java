package com.xml.dto;

import com.xml.model.Advertisement;
import com.xml.model.RentRequest;

public class ReportDto {

    private Long id;
    private CarDto car; //naziv sa fronta, a radimo sa DTO (imena moraju biti ista!!)
    private float km;
    private String additionalInformation;

    public ReportDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
