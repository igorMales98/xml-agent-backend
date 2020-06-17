package com.xml.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateReportDto {

    private Long id;

    @NotNull(message = "Car cannot be null")
    private CarDto car;

    @NotNull(message = "kilometres cannot be empty")
    private float km;

    @NotBlank(message = "Additional information cannot be empty")
    private String additionalInformation;

    @NotNull
    private RentRequestDto rentRequest;

    public CreateReportDto() {
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

    public RentRequestDto getRentRequest() {
        return rentRequest;
    }

    public void setRentRequest(RentRequestDto rentRequest) {
        this.rentRequest = rentRequest;
    }
}
