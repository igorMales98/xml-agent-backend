package com.xml.service.impl;

import com.xml.dto.CreateAdvertisementDto;
import com.xml.mapper.*;
import com.xml.model.Advertisement;
import com.xml.model.Car;
import com.xml.model.User;
import com.xml.repository.AdvertisementRepository;
import com.xml.repository.CarRepository;
import com.xml.service.AdvertisementService;
import com.xml.service.CarService;
import com.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private CarBrandDtoMapper carBrandDtoMapper;

    @Autowired
    private CarModelDtoMapper carModelDtoMapper;

    @Autowired
    private CarClassDtoMapper carClassDtoMapper;

    @Autowired
    private FuelTypeDtoMapper fuelTypeDtoMapper;

    @Autowired
    private TransmissionTypeDtoMapper transmissionTypeDtoMapper;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Override
    public Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto) {
        Car newCar = new Car();
        try {
            newCar.setCarBrand(carBrandDtoMapper.toEntity(createAdvertisementDto.getCarBrand()));
            newCar.setCarModel(carModelDtoMapper.toEntity(createAdvertisementDto.getCarModel()));
            newCar.setCarClass(carClassDtoMapper.toEntity(createAdvertisementDto.getCarClass()));
            newCar.setFuelType(fuelTypeDtoMapper.toEntity(createAdvertisementDto.getFuelType()));
            newCar.setTransmissionType(transmissionTypeDtoMapper.toEntity(createAdvertisementDto.getTransmissionType()));
            newCar.setMileage(createAdvertisementDto.getMileage());
            newCar.setCollisionDamageWaiverExists(createAdvertisementDto.isHasACDW());
            newCar.setChildSeats(createAdvertisementDto.getChildSeats());
            newCar.setAllowedDistance(createAdvertisementDto.getAllowedDistance());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.carService.save(newCar);

        User advertiser = this.userService.getUser(1L);

        Advertisement advertisement = new Advertisement();
        advertisement.setCar(newCar);
        advertisement.setAdvertiser(advertiser);
        createAdvertisementDto.setAvailableFrom(createAdvertisementDto.getAvailableFrom().
                plus(1, ChronoUnit.DAYS));
        createAdvertisementDto.setAvailableTo(createAdvertisementDto.getAvailableTo().
                plus(1, ChronoUnit.DAYS));
        advertisement.setAvailableFrom(createAdvertisementDto.getAvailableFrom());
        advertisement.setAvailableTo(createAdvertisementDto.getAvailableTo());
        this.advertisementRepository.save(advertisement);
        this.advertisementRepository.flush();
        return advertisement.getId();
    }
}
