package com.deltaband.tools.monthlyreport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "report_type")
public class ReportType extends BaseEntity {

	@NotNull
	private String name;

	public ReportType() {
		super();
	}

	public ReportType(@NotNull String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
