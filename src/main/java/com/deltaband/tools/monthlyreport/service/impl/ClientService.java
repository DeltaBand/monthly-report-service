package com.deltaband.tools.monthlyreport.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltaband.tools.monthlyreport.entity.Client;
import com.deltaband.tools.monthlyreport.repository.ClientRepository;
import com.deltaband.tools.monthlyreport.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Collection<Client> findAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client get(Integer id) {
		return this.clientRepository.getById(id);
	}

	@Override
	public void create(Client client) {
		this.clientRepository.save(client);
	}

	@Override
	public void update(Client client) {
		this.clientRepository.save(client);
	}

	@Override
	public void delete(Integer id) {
		this.clientRepository.deleteById(id);
	}

}
