package com.xml.controller;

import com.xml.dto.AdvertisementDto;
import com.xml.dto.CreateAdvertisementDto;
import com.xml.mapper.AdvertisementDtoMapper;
import com.xml.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/advertisement", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private AdvertisementDtoMapper advertisementDtoMapper;

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
            this.advertisementService.uploadPhotos(files, advertisementId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getInPeriod/{dateFrom}/{dateTo}")
    public ResponseEntity<List<AdvertisementDto>> getInPeriod(@PathVariable("dateFrom") String dateFrom,
                                                              @PathVariable("dateTo") String dateTo) {
        try {
            List<AdvertisementDto> advertisementDtos = this.advertisementService.getInPeriod(dateFrom, dateTo).stream()
                    .map(advertisementDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(advertisementDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getAdvertisementsPhotos")
    public ResponseEntity<?> getAdvertisementsPhotos() {
        try {
            Path resourceDirectory = Paths.get("src", "main", "resources");
            String path = resourceDirectory.toFile().getAbsolutePath() + "\\images\\advertisement\\" + '1' + "\\";
            Set<String> allFiles = Stream.of(new File(path).listFiles())
                    .filter(file -> !file.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toSet());
            System.out.println(allFiles);
            byte[] fileContent = new byte[0];
            for (String file : allFiles) {
                File image = new File(file);
                fileContent = Files.readAllBytes(image.toPath());
            }

            return new ResponseEntity<>(fileContent, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
