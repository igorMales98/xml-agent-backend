package com.xml.service.impl;

import com.xml.dto.CreateReportDto;
import com.xml.dto.ReportDto;
import com.xml.mapper.CreateReportDtoMapper;
import com.xml.mapper.ReportDtoMapper;
import com.xml.model.Car;
import com.xml.model.Report;
import com.xml.repository.ReportRepository;
import com.xml.service.CarService;
import com.xml.service.RentRequestService;
import com.xml.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CreateReportDtoMapper createReportDtoMapper;

    @Autowired
    private CarService carService;

    @Override
    public void createReport(CreateReportDto reportDto) throws ParseException {
        Car car = this.carService.getOne(reportDto.getCar().getId());
        car.setMileage(car.getMileage() + reportDto.getKm());
        this.carService.save(car);
        this.reportRepository.save(createReportDtoMapper.toEntity(reportDto));
    }

    @Override
    public float getRentMileage(Long carId) {
        List<Report> reports = this.reportRepository.getAllReportsForACar(carId);
        float milege = 0;
        for (Report report : reports) {
            milege += report.getKm();
        }
        return milege;
    }
}