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

import com.deltaband.tools.monthlyreport.entity.Client;
import com.deltaband.tools.monthlyreport.service.IClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping(name = "clients", path = "clients")
@Tag(name = "Clients", description = "Clients API")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@GetMapping(produces = "application/json")
	@Operation(summary = "Get all clients", description = "Gets all the clients in a non paginated collection")
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Client> find() {
		return clientService.findAll();
	}

	@GetMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Get a single client", description = "Gets a single client")
	@ResponseStatus(code = HttpStatus.OK)
	public Client getOne(@PathVariable Integer id) {
		return clientService.get(id);
	}

	@PostMapping(produces = "application/json")
	@Operation(summary = "Create client", description = "Creates a client if the given client is valid")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid Client client) {
		clientService.create(client);
	}

	@PutMapping(produces = "application/json", consumes = "application/json", path = "{id}")
	@Operation(summary = "Update client", description = "Updates a client if the given client is valid")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid Client client) {
		client.setId(id);
		clientService.update(client);
	}

	@DeleteMapping(produces = "application/json", path = "{id}")
	@Operation(summary = "Delete client", description = "Deletes a client if the given client id is valid")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		clientService.delete(id);
	}
}
