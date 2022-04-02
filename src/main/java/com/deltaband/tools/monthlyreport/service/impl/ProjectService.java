package com.deltaband.tools.monthlyreport.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltaband.tools.monthlyreport.entity.Project;
import com.deltaband.tools.monthlyreport.repository.ProjectRepository;
import com.deltaband.tools.monthlyreport.service.IProjectService;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Collection<Project> findAll() {
		return this.projectRepository.findAll();
	}

	@Override
	public void create(Project entity) {
		this.projectRepository.save(entity);
	}

	@Override
	public Project get(Integer id) {
		return this.projectRepository.getById(id);
	}

	@Override
	public void update(Project entity) {
		this.projectRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		this.projectRepository.deleteById(id);
	}

}
