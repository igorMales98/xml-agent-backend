package com.xml.controller;

import com.xml.dto.CarClassDto;
import com.xml.dto.CarModelDto;
import com.xml.mapper.CarClassDtoMapper;
import com.xml.service.CarClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/car-class", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarClassController {

    @Autowired
    private CarClassService carClassService;

    @Autowired
    private CarClassDtoMapper carClassDtoMapper;

    @GetMapping(value = "")
    public ResponseEntity<List<CarClassDto>> getBrandModels() {
        try {
            List<CarClassDto> carClassDtos = this.carClassService.getAll().stream()
                    .map(carClassDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(carClassDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
