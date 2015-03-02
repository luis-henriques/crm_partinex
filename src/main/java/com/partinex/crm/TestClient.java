package com.partinex.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.partinex.crm.dao.ClientDAO;
import com.partinex.crm.model.Client;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class TestClient extends AbstractTestNGSpringContextTests {
	
	@Autowired
	ClientDAO clientDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Test
	void testClientDao() {
		
		Client client = clientDao.get(1);
		logger.info("Testing!!!");
		
		Assert.assertNotNull(client);
		
	}
	
}
