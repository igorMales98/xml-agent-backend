package com.xml.service.impl;

import com.xml.dto.CreateAdvertisementDto;
import com.xml.repository.AdvertisementRepository;
import com.xml.service.AdvertisementService;
import com.xml.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private CarService carService;

    @Override
    public Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto) {

        return null;
    }
}
