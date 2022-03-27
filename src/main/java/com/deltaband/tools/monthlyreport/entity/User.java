package com.deltaband.tools.monthlyreport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.deltaband.tools.monthlyreport.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@NotNull
	@NotEmpty
	@JsonView(View.Post.class)
	private String name;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
