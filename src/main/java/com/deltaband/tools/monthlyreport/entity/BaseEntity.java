package com.deltaband.tools.monthlyreport.entity;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.deltaband.tools.monthlyreport.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Get.class)
	private Integer id;

	@JsonView(View.Get.class)
	private Instant createdAt = Instant.now();

	@JsonView(View.Get.class)
	private Instant updatedAt;

	public BaseEntity() {
	}

	public BaseEntity(Integer id, Instant createdAt, Instant updatedAt) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
}
