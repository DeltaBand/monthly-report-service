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

import com.deltaband.tools.monthlyreport.entity.ReportType;
import com.deltaband.tools.monthlyreport.service.IReportTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping(name = "types", path = "reports/types")
@Tag(name = "Report Types", description = "Report Types API")
public class ReportTypeController {

	@Autowired
	private IReportTypeService reportTypeService;

	@GetMapping(produces = "application/json")
	@Operation(summary = "Get all Report Types", description = "Gets all the Report Types in a non paginated collection")
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<ReportType> find() {
		return this.reportTypeService.findAll();
	}

	@GetMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Get a single report type", description = "Gets a single report type")
	@ResponseStatus(code = HttpStatus.OK)
	public ReportType getOne(@PathVariable Integer id) {
		return this.reportTypeService.get(id);
	}

	@PostMapping(produces = "application/json")
	@Operation(summary = "Create report type", description = "Creates a report type if the given report type is valid")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid ReportType reportType) {
		this.reportTypeService.create(reportType);
	}

	@PutMapping(produces = "application/json", consumes = "application/json", path = "{id}")
	@Operation(summary = "Update report type", description = "Updates a report type if the given report type is valid")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid ReportType reportType) {
		reportType.setId(id);
		this.reportTypeService.update(reportType);
	}

	@DeleteMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Delete report type", description = "Deletes a report if the given report type id is valid")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		this.reportTypeService.delete(id);
	}

}
