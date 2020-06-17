package com.xml.controller;

import com.xml.dto.CarBrandDto;
import com.xml.mapper.CarBrandDtoMapper;
import com.xml.model.CarBrand;
import com.xml.service.CarBrandService;
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
@RequestMapping(value = "/api/car-brand", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private CarBrandDtoMapper carBrandDtoMapper;

    @GetMapping(value = "")
    public ResponseEntity<List<CarBrandDto>> getAll() {

        try {
            List<CarBrandDto> carBrandDtos = this.carBrandService.getAll()
                    .stream().map(carBrandDtoMapper::toDto).
                            collect(Collectors.toList());
            return new ResponseEntity<>(carBrandDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
