package com.xml.controller;

import com.xml.RentCar.wsdl.RentRequestResponse;
import com.xml.dto.RentRequestDto;
import com.xml.mapper.RentRequestDtoMapper;
import com.xml.service.RentRequestService;
import com.xml.soap.RentRequestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/rent-request", produces = MediaType.APPLICATION_JSON_VALUE)
public class RentRequestController {

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private RentRequestDtoMapper rentRequestDtoMapper;

    @Autowired
    private RentRequestClient rentRequestClient;

    @PostMapping(value = "")
    public ResponseEntity<?> createRentRequest(@Valid @RequestBody RentRequestDto rentRequestDto) {
        try {
            RentRequestResponse response = this.rentRequestClient.postRentRequest(rentRequestDto);
            this.rentRequestService.createRentRequest(rentRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<List<RentRequestDto>> getAll() {

        try {
            List<RentRequestDto> rentRequestDtos = this.rentRequestService.getAll()
                    .stream().map(rentRequestDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(rentRequestDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/finished")
    public ResponseEntity<List<RentRequestDto>> getFinishedRents() {
        try {
            List<RentRequestDto> rentRequests = this.rentRequestService.getFinishedRents().stream()
                    .map(rentRequestDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(rentRequests, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
