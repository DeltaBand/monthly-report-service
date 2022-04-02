package com.deltaband.tools.monthlyreport.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltaband.tools.monthlyreport.entity.Report;
import com.deltaband.tools.monthlyreport.repository.ReportRepository;
import com.deltaband.tools.monthlyreport.service.IReportService;

@Service
public class ReportService implements IReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Collection<Report> findAll() {
		return this.reportRepository.findAll();
	}

	@Override
	public void create(Report entity) {
		this.reportRepository.save(entity);
	}

	@Override
	public Report get(Integer id) {
		return this.reportRepository.getById(id);
	}

	@Override
	public void update(Report entity) {
		this.reportRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		this.reportRepository.deleteById(id);
		;
	}

}
