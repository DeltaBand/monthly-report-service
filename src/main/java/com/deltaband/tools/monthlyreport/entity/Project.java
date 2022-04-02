package com.deltaband.tools.monthlyreport.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	@NotNull
	private String name;

	@JsonBackReference
	@ManyToOne(targetEntity = Client.class)
	private Client client;

	public Project() {
		super();
	}

	public Project(@NotNull String name, Client client) {
		super();
		this.name = name;
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
