package com.xml.controller;

import com.xml.dto.CarDto;
import com.xml.mapper.CarDtoMapper;
import com.xml.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarDtoMapper carDtoMapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<CarDto>> getAllCars() {
        try {
            List<CarDto> carDtos = this.carService.getAll().stream()
                    .map(carDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(carDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
