package com.partinex.crm.dao;

import java.util.List;

import com.partinex.crm.model.Client;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class ClientDAOImpl implements ClientDAO {
	
	private SessionFactory sessionFactory;
	
	public ClientDAOImpl() {
		super();
	}
	
	public ClientDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Client> list() {
		@SuppressWarnings("unchecked")
		List<Client> listClient = (List<Client>) sessionFactory.getCurrentSession()
				.createCriteria(Client.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listClient;
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Client client) {
		sessionFactory.getCurrentSession().saveOrUpdate(client);
	}

	@Override
	@Transactional
	public void delete(int clientId) {
		Client clientToDelete = new Client();
		clientToDelete.setId(clientId);
		sessionFactory.getCurrentSession().delete(clientToDelete);
	}

	@Override
	@Transactional
	public Client get(int clientId) {
		return (Client) sessionFactory.getCurrentSession().get(Client.class, clientId);
	}

	@Override
	@Transactional
	public Client getByNIF(int clientNIF) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.eq("nif", clientNIF));
		if(criteria.list().size()==0) return null;
		return (Client) criteria.list().get(0);
	}

	@Override
	@Transactional
	public List<Client> getByName(String clientName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.ilike("name", "%" + clientName + "%"));
		if(criteria.list().size()==0) return null;
		return criteria.list();
	}
	
}