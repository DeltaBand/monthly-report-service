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

import com.deltaband.tools.monthlyreport.entity.Report;
import com.deltaband.tools.monthlyreport.service.IReportService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping(name = "reports", path = "reports")
@Tag(name = "Reports", description = "Reports API")
public class ReportController {

	@Autowired
	private IReportService reportService;

	@GetMapping(produces = "application/json")
	@Operation(summary = "Get all Reports", description = "Gets all the Reports in a non paginated collection")
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Report> find() {
		return this.reportService.findAll();
	}

	@GetMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Get a single report", description = "Gets a single report")
	@ResponseStatus(code = HttpStatus.OK)
	public Report getOne(@PathVariable Integer id) {
		return this.reportService.get(id);
	}

	@PostMapping(produces = "application/json")
	@Operation(summary = "Create report", description = "Creates a report if the given user is valid")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid Report report) {
		this.reportService.create(report);
	}

	@PutMapping(produces = "application/json", consumes = "application/json", path = "{id}")
	@Operation(summary = "Update report", description = "Updates a report if the given report is valid")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid Report report) {
		report.setId(id);
		this.reportService.update(report);
	}

	@DeleteMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Delete report", description = "Deletes a report if the given report id is valid")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		this.reportService.delete(id);
	}

}
