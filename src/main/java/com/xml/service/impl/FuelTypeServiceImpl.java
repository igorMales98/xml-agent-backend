package com.xml.service.impl;

import com.xml.model.FuelType;
import com.xml.repository.FuelTypeRepository;
import com.xml.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Override
    public List<FuelType> getAll() {
        return this.fuelTypeRepository.findAll();
    }
}
