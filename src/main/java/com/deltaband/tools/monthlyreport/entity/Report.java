package com.deltaband.tools.monthlyreport.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "report")
public class Report extends BaseEntity {

	@NotNull
	@ManyToOne
	private User user;

	@ManyToOne
	private Project project;

	@NotNull
	@ManyToOne
	private ReportType reportType;

	@NotNull
	private LocalDate date;

	@NotNull
	private Integer hours;

	@NotNull
	private Integer minutes;

	private String description;

	public Report() {
		super();
	}

	public Report(@NotNull User user, Project project, @NotNull ReportType reportType, @NotNull LocalDate date,
			@NotNull Integer hours, @NotNull Integer minutes, String description) {
		super();
		this.user = user;
		this.project = project;
		this.reportType = reportType;
		this.date = date;
		this.hours = hours;
		this.minutes = minutes;
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
