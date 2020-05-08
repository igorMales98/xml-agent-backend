package com.xml.service;

import com.xml.dto.CreateReportDto;

import java.text.ParseException;

public interface ReportService {

    void createReport(CreateReportDto reportDto) throws ParseException;

    float getRentMileage(Long carId);
}
