package com.deltaband.tools.monthlyreport.service;

import java.util.Collection;

public interface ICrudService<T> {

	Collection<T> findAll();

	void create(T entity);

	T get(Integer id);

	void update(T entity);

	void delete(Integer id);

}
