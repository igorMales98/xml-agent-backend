package com.xml.service.impl;

import com.xml.model.CarBrand;
import com.xml.repository.CarBrandRepository;
import com.xml.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;


    @Override
    public List<CarBrand> getAll() {
        return this.enabledBrands(this.carBrandRepository.findAll());
    }

    private List<CarBrand> enabledBrands(List<CarBrand> carBrands) {
        List<CarBrand> temp = new ArrayList<>();
        for (CarBrand carBrand : carBrands) {
            if (carBrand.isEnabled()) {
                temp.add(carBrand);
            }
        }
        return temp;
    }
}
