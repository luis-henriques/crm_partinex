package com.partinex.crm.dao;

import java.util.List;

import com.partinex.crm.model.Client;

public interface ClientDAO {
	
	public List<Client> list();

	public void saveOrUpdate(Client client);

	public void delete(int clientId);

	public Client get(int clientId);
	
	public Client getByNIF(int clientNIF);

	public List<Client> getByName(String clientName);
	
}