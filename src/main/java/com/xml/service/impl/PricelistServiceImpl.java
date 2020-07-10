package com.xml.service.impl;

import com.xml.RentCar.wsdl.PricelistResponse;
import com.xml.dto.PricelistDto;
import com.xml.mapper.PricelistDtoMapper;
import com.xml.model.Advertisement;
import com.xml.model.Pricelist;
import com.xml.repository.PricelistRepository;
import com.xml.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistDtoMapper pricelistDtoMapper;

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public List<Pricelist> getAll() {
        return this.enabledPricelists(this.pricelistRepository.findAll());
    }

    @Override
    public void savePricelist(PricelistDto pricelistDto/*, PricelistResponse response*/) {
        Pricelist newPricelist = new Pricelist();

        newPricelist.setPricePerDay(pricelistDto.getPricePerDay());
        newPricelist.setPricePerKm(pricelistDto.getPricePerKm());
        newPricelist.setPriceForCDW(pricelistDto.getPriceForCDW());
        newPricelist.setEnabled(true);
        //newPricelist.setRealId(response.getPricelistId());

        this.pricelistRepository.save(newPricelist);
    }

    @Override
    public void deletePrice(Long id) {

        Pricelist pricelistForDelete = this.pricelistRepository.getOne(id);
        pricelistForDelete.setEnabled(false);
        this.pricelistRepository.save(pricelistForDelete);

    }

    @Override
    public void editPrice(PricelistDto pricelistDto) {

        Pricelist pricelistToEdit = this.pricelistRepository.getOne(pricelistDto.getId());
        pricelistToEdit.setPricePerDay(pricelistDto.getPricePerDay());
        pricelistToEdit.setPricePerKm(pricelistDto.getPricePerKm());
        pricelistToEdit.setPriceForCDW(pricelistDto.getPriceForCDW());
        this.pricelistRepository.save(pricelistToEdit);

    }

    private List<Pricelist> enabledPricelists(List<Pricelist> pricelists) {
        List<Pricelist> temp = new ArrayList<>();
        for (Pricelist pricelist : pricelists) {
            if (pricelist.isEnabled()) {
                temp.add(pricelist);
            }
        }
        return temp;
    }

}
