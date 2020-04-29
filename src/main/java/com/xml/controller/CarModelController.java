package com.xml.controller;

import com.xml.dto.CarModelDto;
import com.xml.mapper.CarModelDtoMapper;
import com.xml.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/car-model", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarModelDtoMapper carModelDtoMapper;

    @GetMapping(value = "/getBrandModels/{modelId}")
    public ResponseEntity<List<CarModelDto>> getBrandModels(@PathVariable("modelId") Long modelId) {
        try {
            List<CarModelDto> carModelDtos = this.carModelService.getBrandModels(modelId).stream()
                    .map(carModelDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(carModelDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
