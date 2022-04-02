package com.deltaband.tools.monthlyreport.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltaband.tools.monthlyreport.entity.ReportType;
import com.deltaband.tools.monthlyreport.repository.ReportTypeRepository;
import com.deltaband.tools.monthlyreport.service.IReportTypeService;

@Service
public class ReportTypeService implements IReportTypeService {

	@Autowired
	private ReportTypeRepository reportTypeRepository;

	@Override
	public Collection<ReportType> findAll() {
		return this.reportTypeRepository.findAll();
	}

	@Override
	public void create(ReportType entity) {
		this.reportTypeRepository.save(entity);
	}

	@Override
	public ReportType get(Integer id) {
		return this.reportTypeRepository.getById(id);
	}

	@Override
	public void update(ReportType entity) {
		this.reportTypeRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		this.reportTypeRepository.deleteById(id);
	}

}
