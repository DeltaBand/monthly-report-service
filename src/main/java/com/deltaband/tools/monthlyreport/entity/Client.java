package com.deltaband.tools.monthlyreport.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {

	@NotNull
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private Collection<Project> projects;

	public Client() {
		super();
	}

	public Client(@NotNull String name, Collection<Project> projects) {
		super();
		this.name = name;
		this.projects = projects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

}
