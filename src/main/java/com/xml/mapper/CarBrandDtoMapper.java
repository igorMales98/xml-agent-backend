package com.xml.mapper;

import com.xml.dto.CarBrandDto;
import com.xml.model.CarBrand;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class CarBrandDtoMapper implements MapperInterface<CarBrand, CarBrandDto> {

    private ModelMapper modelMapper;

    @Override
    public CarBrand toEntity(CarBrandDto dto) throws ParseException {
        return modelMapper.map(dto, CarBrand.class);
    }

    @Override
    public CarBrandDto toDto(CarBrand entity) {
        return modelMapper.map(entity, CarBrandDto.class);
    }
}
