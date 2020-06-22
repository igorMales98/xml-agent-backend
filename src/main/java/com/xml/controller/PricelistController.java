package com.xml.controller;

import com.xml.RentCar.wsdl.PricelistResponse;
import com.xml.dto.PricelistDto;
import com.xml.mapper.PricelistDtoMapper;
import com.xml.model.Pricelist;
import com.xml.service.PricelistService;
import com.xml.soap.PricelistClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private PricelistClient pricelistClient;

    @GetMapping(value = "")
    public ResponseEntity<List<PricelistDto>> getAll() {
        try {
            List<PricelistDto> pricelistDtos = this.pricelistService.getAll().stream()
                    .map(pricelistDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(pricelistDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addPricelist(@Valid @RequestBody PricelistDto pricelistDto) {
        System.out.println("Stampa: " + pricelistDto.getPricePerDay());
        try {
            PricelistResponse response = this.pricelistClient.postPricelist(pricelistDto);
            this.pricelistService.savePricelist(pricelistDto, response);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Long id) throws ParseException {

        try {
            this.pricelistService.deletePrice(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editPrice(@Valid @RequestBody PricelistDto pricelistDto) {
        try {
            this.pricelistService.editPrice(pricelistDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
