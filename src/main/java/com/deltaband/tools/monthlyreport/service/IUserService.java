package com.deltaband.tools.monthlyreport.service;

import java.util.Collection;

import com.deltaband.tools.monthlyreport.entity.User;

public interface IUserService {
	Collection<User> findAll();

	User get(Integer id);

	void create(User user);

	void update(User user);

	void delete(Integer id);
}
