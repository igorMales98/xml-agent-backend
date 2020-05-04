package com.xml.service.impl;

import com.xml.dto.PricelistDto;
import com.xml.mapper.PricelistDtoMapper;
import com.xml.model.Pricelist;
import com.xml.repository.PricelistRepository;
import com.xml.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistDtoMapper pricelistDtoMapper;

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public List<Pricelist> getAll() {
        return this.pricelistRepository.findAll();
    }

    @Override
    public void savePricelist(PricelistDto pricelistDto) {
        Pricelist newPricelist = new Pricelist();

        try{
            newPricelist.setPricePerDay(pricelistDto.getPricePerDay());
            newPricelist.setPricePerKm(pricelistDto.getPricePerKm());
            newPricelist.setPriceForCDW(pricelistDto.getPriceForCDW());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.pricelistRepository.save(newPricelist);
    }

    @Override
    public void deletePrice(Long id) {

        Pricelist pricelistForDelete = this.pricelistRepository.findOneById(id);
        try {
            this.pricelistRepository.delete(pricelistForDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editPrice(PricelistDto pricelistDto) {

        Pricelist pricelistToEdit = this.pricelistRepository.findOneById(pricelistDto.getId());
        try{
            pricelistToEdit.setPricePerDay(pricelistDto.getPricePerDay());
            pricelistToEdit.setPricePerKm(pricelistDto.getPricePerKm());
            pricelistToEdit.setPriceForCDW(pricelistDto.getPriceForCDW());
            this.pricelistRepository.save(pricelistToEdit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
