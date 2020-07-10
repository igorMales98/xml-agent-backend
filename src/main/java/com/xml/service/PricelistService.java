package com.xml.service;

import com.xml.RentCar.wsdl.PricelistResponse;
import com.xml.dto.PricelistDto;
import com.xml.model.Pricelist;

import java.util.List;

public interface PricelistService {

    List<Pricelist> getAll();
    void savePricelist(PricelistDto pricelistDto/*, PricelistResponse response*/);
    void deletePrice(Long id);
    void editPrice(PricelistDto pricelistDto);


}
