package com.xml.service;

import com.xml.model.CarModel;

import java.util.List;

public interface CarModelService {
    List<CarModel> getBrandModels(Long modelId);
}
