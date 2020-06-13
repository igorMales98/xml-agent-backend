package com.xml.service.impl;

import com.xml.model.CarClass;
import com.xml.repository.CarClassRepository;
import com.xml.service.CarClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarClassServiceImpl implements CarClassService {

    @Autowired
    private CarClassRepository carClassRepository;

    @Override
    public List<CarClass> getAll() {
        return this.enabledClasses(this.carClassRepository.findAll());
    }

    private List<CarClass> enabledClasses(List<CarClass> carClasses) {
        List<CarClass> temp = new ArrayList<>();
        for (CarClass carClass : carClasses) {
            if (carClass.isEnabled()) {
                temp.add(carClass);
            }
        }
        return temp;
    }
}
