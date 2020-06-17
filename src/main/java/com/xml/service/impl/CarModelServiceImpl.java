package com.xml.service.impl;

import com.xml.model.CarModel;
import com.xml.repository.CarModelRepository;
import com.xml.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public List<CarModel> getBrandModels(Long modelId) {
        return this.enabledModels(this.carModelRepository.getBrandModels(modelId));
    }

    private List<CarModel> enabledModels(List<CarModel> carModels) {
        List<CarModel> temp = new ArrayList<>();
        for (CarModel carModel : carModels) {
            if (carModel.isEnabled()) {
                temp.add(carModel);
            }
        }
        return temp;
    }
}
