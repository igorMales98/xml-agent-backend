package com.xml.controller;

import com.xml.dto.CreateAdvertisementDto;
import com.xml.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/advertisement", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping(value = "/create")
    public ResponseEntity<Long> createAdvertisement(@RequestBody CreateAdvertisementDto createAdvertisementDto) {
        System.out.println(createAdvertisementDto);
        try {
            Long advertisementId = this.advertisementService.saveAdvertisement(createAdvertisementDto);
            return new ResponseEntity<>(advertisementId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/uploadPhotos/{id}")
    public ResponseEntity<?> uploadPhotosForAdvertisement(@RequestPart("myFile") MultipartFile[] files, @PathVariable("id") Long advertisementId) {
        try {
            Path resourceDirectory = Paths.get("src", "main", "resources");
            String path = resourceDirectory.toFile().getAbsolutePath() + "\\images\\advertisement\\" + advertisementId + "\\";
            if (!new File(path).exists()) {
                new File(path).mkdir();
            }
            for (int i = 0; i < files.length; i++) {
                String imgName = files[i].getOriginalFilename();
                String filePath = path + imgName;
                File dest = new File(filePath);
                files[i].transferTo(dest);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
