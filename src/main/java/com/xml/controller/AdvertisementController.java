package com.xml.controller;

import com.xml.dto.CreateAdvertisementDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/advertisement", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdvertisementController {



    @PostMapping(value = "/create")
    public void createAdvertisement(@RequestBody CreateAdvertisementDto createAdvertisementDto) {
        System.out.println(createAdvertisementDto);
    }

    /*@PostMapping(value = "/create")
    public ResponseEntity<?> createAd(@RequestPart("myFile") MultipartFile[] files) {
        System.out.println(files[1].getOriginalFilename());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
