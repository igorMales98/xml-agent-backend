package com.xml.controller;

import com.xml.dto.FuelTypeDto;
import com.xml.dto.PricelistDto;
import com.xml.mapper.PricelistDtoMapper;
import com.xml.model.Pricelist;
import com.xml.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/pricelist", produces = MediaType.APPLICATION_JSON_VALUE)
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private PricelistDtoMapper pricelistDtoMapper;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<PricelistDto>> getAll() {
        try {
            List<PricelistDto> pricelistDtos = this.pricelistService.getAll().stream()
                    .map(pricelistDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(pricelistDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/addPricelist")
    public ResponseEntity<?> addPricelist(@RequestBody PricelistDto pricelistDto) {
        System.out.println("Stampa: " + pricelistDto.getPricePerDay());
        try {
            this.pricelistService.savePricelist(pricelistDto);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/deletePricelist/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Long id) throws ParseException {

        try {
            this.pricelistService.deletePrice(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/editPricelist")
    public ResponseEntity<?> editPrice(@RequestBody PricelistDto pricelistDto){
        try {
            this.pricelistService.editPrice(pricelistDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
