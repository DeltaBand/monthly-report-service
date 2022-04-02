package com.deltaband.tools.monthlyreport.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deltaband.tools.monthlyreport.entity.Project;
import com.deltaband.tools.monthlyreport.service.IProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping(name = "projects", path = "projects")
@Tag(name = "Projects", description = "Projects API")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@GetMapping(produces = "application/json")
	@Operation(summary = "Get all Projects", description = "Gets all the Projects in a non paginated collection")
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Project> find() {
		return this.projectService.findAll();
	}

	@GetMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Get a single project", description = "Gets a single project")
	@ResponseStatus(code = HttpStatus.OK)
	public Project getOne(@PathVariable Integer id) {
		return this.projectService.get(id);
	}

	@PostMapping(produces = "application/json")
	@Operation(summary = "Create project", description = "Creates a project if the given user is valid")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid Project project) {
		this.projectService.create(project);
	}

	@PutMapping(produces = "application/json", consumes = "application/json", path = "{id}")
	@Operation(summary = "Update project", description = "Updates a project if the given project is valid")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid Project project) {
		project.setId(id);
		this.projectService.update(project);
	}

	@DeleteMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Delete project", description = "Deletes a project if the given project id is valid")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		this.projectService.delete(id);
	}

}
