package com.xml.dto;

import java.time.LocalDateTime;

public class CreateAdvertisementDto {

    private CarBrandDto carBrand;
    private CarModelDto carModel;
    private CarClassDto carClass;
    private FuelTypeDto fuelType;
    private TransmissionTypeDto transmissionType;
    private PricelistDto pricelist;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
    private float mileage;
    private int childSeats;
    private boolean hasACDW;

    public CreateAdvertisementDto() {
    }

    public CarBrandDto getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrandDto carBrand) {
        this.carBrand = carBrand;
    }

    public CarModelDto getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModelDto carModel) {
        this.carModel = carModel;
    }

    public CarClassDto getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClassDto carClass) {
        this.carClass = carClass;
    }

    public FuelTypeDto getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeDto fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionTypeDto getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionTypeDto transmissionType) {
        this.transmissionType = transmissionType;
    }

    public PricelistDto getPricelist() {
        return pricelist;
    }

    public void setPricelist(PricelistDto pricelist) {
        this.pricelist = pricelist;
    }

    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDateTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDateTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalDateTime availableTo) {
        this.availableTo = availableTo;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public int getChildSeats() {
        return childSeats;
    }

    public void setChildSeats(int childSeats) {
        this.childSeats = childSeats;
    }

    public boolean isHasACDW() {
        return hasACDW;
    }

    public void setHasACDW(boolean hasACDW) {
        this.hasACDW = hasACDW;
    }

    @Override
    public String toString() {
        return "AdvertisementDto{" +
                "carBrand=" + carBrand +
                ", carModel=" + carModel +
                ", carClass=" + carClass +
                ", fuelType=" + fuelType +
                ", transmissionType=" + transmissionType +
                ", pricelist=" + pricelist +
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", mileage=" + mileage +
                ", childSeats=" + childSeats +
                ", hasACDW=" + hasACDW +
                '}';
    }
}

