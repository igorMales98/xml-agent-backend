package com.xml.service;

import com.xml.dto.RentRequestDto;

import java.text.ParseException;

public interface RentRequestService {

    void createRentRequest(RentRequestDto rentRequestDto) throws ParseException;
}
