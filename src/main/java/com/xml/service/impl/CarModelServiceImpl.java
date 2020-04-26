package com.xml.service.impl;

import com.xml.model.CarModel;
import com.xml.repository.CarModelRepository;
import com.xml.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public List<CarModel> getBrandModels(Long modelId) {
        return this.carModelRepository.getBrandModels(modelId);
    }
}
