package com.deltaband.tools.monthlyreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.deltaband.tools.monthlyreport.entity.Project;

@Repository
public interface ProjectRepository extends JpaSpecificationExecutor<Project>, JpaRepository<Project, Integer> {

}
