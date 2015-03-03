package com.partinex.crm;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.batch.test.JobLauncherTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.partinex.crm.dao.ClientDAO;
import com.partinex.crm.dao.ClientDAOImpl;
import com.partinex.crm.model.Client;

@Test
@ContextConfiguration("classpath:spring-test-config.xml")
public class TestClient extends AbstractTestNGSpringContextTests {
	
	
	private static final int TEST_CLIENT_ID = 34;
	private static final String TEST_CLIENT_NAME = "Ze das Couves";
	private static final int TEST_CLIENT_NIF = 192837645;
	private static final String TEST_CLIENT_ADDRESS = "Rua onde mora";
	private static final int TEST_CLIENT_PHONE_NUMBER = 923416578;
	
	private static final int TEST_CLIENT_2_ID = 29;
	private static final String TEST_CLIENT_2_NAME = "Manel das Conchas";
	private static final int TEST_CLIENT_2_NIF = 182937465;
	private static final String TEST_CLIENT_2_ADDRESS = "Rua da esquina";
	private static final int TEST_CLIENT_2_PHONE_NUMBER = 931247586;
	
	@InjectMocks
	private HomeController homeController;
	
	@Mock
	ClientDAO clientDao;
	
	@BeforeMethod
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testClientDao() {
		
		Client client = new Client(TEST_CLIENT_ID, TEST_CLIENT_NAME, TEST_CLIENT_NIF, TEST_CLIENT_ADDRESS, TEST_CLIENT_PHONE_NUMBER);
		Mockito.when(clientDao.get(TEST_CLIENT_ID)).thenReturn(client);
		
		Assert.assertEquals(clientDao.get(TEST_CLIENT_ID).getName(), TEST_CLIENT_NAME);
		
	}
	
	
	
	
}
