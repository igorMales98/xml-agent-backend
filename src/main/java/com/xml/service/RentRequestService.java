package com.xml.service;

import com.xml.dto.RentRequestDto;
import com.xml.model.Advertisement;
import com.xml.model.RentRequest;

import java.text.ParseException;
import java.util.List;

public interface RentRequestService {

    void createRentRequest(RentRequestDto rentRequestDto) throws ParseException;

    List<RentRequest> getAll();

    RentRequest getOne(Long id);

}
