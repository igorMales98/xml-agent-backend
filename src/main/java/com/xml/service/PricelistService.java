package com.xml.service;

import com.xml.dto.PricelistDto;
import com.xml.model.Pricelist;

import java.util.List;

public interface PricelistService {

    List<Pricelist> getAll();
    void savePricelist(PricelistDto pricelistDto);
    void deletePrice(Long id);
    void editPrice(PricelistDto pricelistDto);


}
