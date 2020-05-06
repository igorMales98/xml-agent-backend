package com.xml.service.impl;

import com.xml.dto.ReportDto;
import com.xml.mapper.ReportDtoMapper;
import com.xml.model.Report;
import com.xml.repository.ReportRepository;
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
    private ReportDtoMapper reportDtoMapper;

    @Override
    public void createReport(ReportDto reportDto) throws ParseException {
        this.reportRepository.save(reportDtoMapper.toEntity(reportDto));
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
