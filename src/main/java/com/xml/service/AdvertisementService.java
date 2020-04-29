package com.xml.service;

import com.xml.dto.CreateAdvertisementDto;

public interface AdvertisementService {
    Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto);
}
