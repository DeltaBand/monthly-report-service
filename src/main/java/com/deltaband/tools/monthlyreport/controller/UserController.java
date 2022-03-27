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

import com.deltaband.tools.monthlyreport.entity.User;
import com.deltaband.tools.monthlyreport.service.IUserService;
import com.deltaband.tools.monthlyreport.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping(name = "users")
@Tag(name = "Users", description = "Users API")
public class UserController {

	@Autowired
	private IUserService userService;

	@JsonView(View.Get.class)
	@GetMapping(produces = "application/json")
	@Operation(summary = "Get all Users", description = "Gets all the Users in a non paginated collection")
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<User> get() {
		return userService.findAll();
	}

	@JsonView(View.Post.class)
	@PostMapping(produces = "application/json")
	@Operation(summary = "Create user", description = "Creates an user if the given user is valid")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid User user) {
		userService.create(user);
	}

	@JsonView(View.Put.class)
	@PutMapping(produces = "application/json", consumes = "application/json", path = "{id}")
	@Operation(summary = "Update user", description = "Updates an user if the given user is valid")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid User user) {
		user.setId(id);
		userService.update(user);
	}

	@DeleteMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Delete user", description = "Deletes an user if the given user id is valid")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}
}
