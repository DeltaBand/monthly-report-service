package com.deltaband.tools.monthlyreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.deltaband.tools.monthlyreport.entity.Report;

@Repository
public interface ReportRepository extends JpaSpecificationExecutor<Report>, JpaRepository<Report, Integer> {

}
