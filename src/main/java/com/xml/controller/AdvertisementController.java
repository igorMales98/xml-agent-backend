package com.xml.controller;

import com.xml.RentCar.wsdl.AdvertisementResponse;
import com.xml.dto.AdvertisementDto;
import com.xml.dto.CreateAdvertisementDto;
import com.xml.mapper.AdvertisementDtoMapper;
import com.xml.service.AdvertisementService;
import com.xml.soap.AdvertisementClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/advertisement", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private AdvertisementDtoMapper advertisementDtoMapper;

    @Autowired
    private AdvertisementClient client;

    @PostMapping(value = "")
    public ResponseEntity<Long> createAdvertisement(@Valid @RequestBody CreateAdvertisementDto createAdvertisementDto) {
        System.out.println(createAdvertisementDto);
        try {
            //AdvertisementResponse response = client.postAdvertisement(createAdvertisementDto);
            Long advertisementId = this.advertisementService.saveAdvertisement(createAdvertisementDto/*, response*/);
            return new ResponseEntity<>(advertisementId, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/uploadPhotos/{id}")
    public ResponseEntity<?> uploadPhotosForAdvertisement(@RequestPart("myFile") MultipartFile[] files, @PathVariable("id") Long advertisementId) {
        try {
            this.advertisementService.uploadPhotos(files, advertisementId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/inPeriod/{dateFrom}/{dateTo}")
    public ResponseEntity<List<AdvertisementDto>> getInPeriod(@PathVariable("dateFrom") String dateFrom,
                                                              @PathVariable("dateTo") String dateTo) {
        try {
            List<AdvertisementDto> advertisementDtos = this.advertisementService.getInPeriod(dateFrom, dateTo).stream()
                    .map(advertisementDtoMapper::toDto).collect(Collectors.toList());
            for (AdvertisementDto advertisementDto : advertisementDtos) {
                advertisementDto.setImg(this.advertisementService.getAdvertisementPhotos(advertisementDto.getId()));
            }
            return new ResponseEntity<>(advertisementDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{agentId}")
    public ResponseEntity<List<AdvertisementDto>> getAll(@PathVariable("agentId") Long agentId) {
        try {
            List<AdvertisementDto> advertisementDtos = this.advertisementService.getAll(agentId).stream()
                    .map(advertisementDtoMapper::toDto).collect(Collectors.toList());
            for (AdvertisementDto advertisementDto : advertisementDtos) {
                advertisementDto.setImg(this.advertisementService.getAdvertisementPhotos(advertisementDto.getId()));
            }
            return new ResponseEntity<>(advertisementDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*@GetMapping(value = "/photos/{id}")
    public ResponseEntity<?> getAdvertisementsPhotos(@PathVariable("id") Long id) {
        try {
            List<String> allEncodedImages = this.advertisementService.getAdvertisementPhotos(id);
            return new ResponseEntity<>(allEncodedImages, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @GetMapping(value = "/timesRented/{id}")
    public ResponseEntity<Integer> getTimesRented(@PathVariable("id") Long id) {
        try {
            Integer timesRented = this.advertisementService.getTimesRented(id);
            return new ResponseEntity<>(timesRented, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
