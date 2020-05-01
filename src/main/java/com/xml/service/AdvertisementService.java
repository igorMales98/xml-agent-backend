package com.xml.service;

import com.xml.dto.CreateAdvertisementDto;
import com.xml.model.Advertisement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdvertisementService {
    Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto);

    void uploadPhotos(MultipartFile[] files, Long id) throws IOException;

    List<Advertisement> getInPeriod(String dateFrom, String dateTo);
}
