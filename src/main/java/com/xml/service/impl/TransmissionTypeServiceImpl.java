package com.xml.service.impl;

import com.xml.model.TransmissionType;
import com.xml.repository.TransmissionTypeRepository;
import com.xml.service.TransmissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransmissionTypeServiceImpl implements TransmissionTypeService {

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    @Override
    public List<TransmissionType> getAll() {
        return this.enabledTransmissionTypes(this.transmissionTypeRepository.findAll());
    }

    private List<TransmissionType> enabledTransmissionTypes(List<TransmissionType> transmissionTypes) {
        List<TransmissionType> temp = new ArrayList<>();
        for (TransmissionType transmissionType : transmissionTypes) {
            if (transmissionType.isEnabled()) {
                temp.add(transmissionType);
            }
        }
        return temp;
    }
}
