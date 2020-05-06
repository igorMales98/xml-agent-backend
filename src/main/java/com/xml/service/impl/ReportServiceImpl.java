package com.xml.service.impl;

import com.xml.dto.ReportDto;
import com.xml.mapper.ReportDtoMapper;
import com.xml.repository.ReportRepository;
import com.xml.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportDtoMapper reportDtoMapper;

    @Override
    public void createReport(ReportDto reportDto) throws ParseException {
        System.out.println(reportDto);
        this.reportRepository.save(reportDtoMapper.toEntity(reportDto));
    }
}
