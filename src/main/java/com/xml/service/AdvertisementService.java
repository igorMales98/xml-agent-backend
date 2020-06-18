package com.xml.service;

import com.xml.RentCar.wsdl.AdvertisementResponse;
import com.xml.dto.CreateAdvertisementDto;
import com.xml.model.Advertisement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface AdvertisementService {
    Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto, AdvertisementResponse response) throws ParseException;

    void uploadPhotos(MultipartFile[] files, Long id) throws IOException;

    List<Advertisement> getInPeriod(String dateFrom, String dateTo);

    List<String> getAdvertisementPhotos(Long id) throws IOException;

    List<Advertisement> getAll(Long agentId);

    Integer getTimesRented(Long id);
}
