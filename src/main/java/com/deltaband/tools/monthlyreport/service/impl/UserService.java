package com.deltaband.tools.monthlyreport.service.impl;

import java.time.Instant;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltaband.tools.monthlyreport.entity.User;
import com.deltaband.tools.monthlyreport.repository.UserRepository;
import com.deltaband.tools.monthlyreport.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User get(Integer id) {
		return userRepository.getById(id);
	}

	@Override
	public void create(User user) {
		this.userRepository.save(user);
	}

	@Override
	public void update(User user) {
		user.setUpdatedAt(Instant.now());
		this.userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		this.userRepository.deleteById(id);
	}

}
