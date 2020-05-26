package com.xml.service.impl;

import com.xml.dto.AdvertisementDto;
import com.xml.dto.CreateReportDto;
import com.xml.mapper.CreateReportDtoMapper;
import com.xml.mapper.UserDtoMapper;
import com.xml.model.AdditionalBill;
import com.xml.model.Car;
import com.xml.model.Report;
import com.xml.repository.AdditionalBillRepository;
import com.xml.repository.ReportRepository;
import com.xml.service.CarService;
import com.xml.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.owasp.encoder.Encode;

import java.io.PrintWriter;
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

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private AdditionalBillRepository additionalBillRepository;

    @Override
    public void createReport(CreateReportDto reportDto) throws ParseException {
        Car car = this.carService.getOne(reportDto.getCar().getId());
        car.setMileage(car.getMileage() + reportDto.getKm());
        this.carService.save(car);
        this.reportRepository.save(createReportDtoMapper.toEntity(reportDto));

        if (reportDto.getKm() > car.getAllowedDistance()) {
            AdditionalBill additionalBill = new AdditionalBill();
            additionalBill.setCustomer(userDtoMapper.toEntity(reportDto.getRentRequest().getCustomer()));
            AdvertisementDto advertisementDto = null;
            for (AdvertisementDto advertisementDto1 : reportDto.getRentRequest().getAdvertisementsForRent()) {
                if (advertisementDto1.getCar().getId().equals(car.getId())) {
                    advertisementDto = advertisementDto1;
                    break;
                }
            }
            float distance = reportDto.getKm() - car.getAllowedDistance();
            float price = advertisementDto.getPricelist().getPricePerKm();
            additionalBill.setPrice(distance * price);
            this.additionalBillRepository.save(additionalBill);
        }
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
