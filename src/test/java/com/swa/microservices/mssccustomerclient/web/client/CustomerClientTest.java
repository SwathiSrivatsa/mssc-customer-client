package com.swa.microservices.mssccustomerclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.swa.microservices.mssccustomerclient.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {

	@Autowired
	CustomerClient customerClient;
	
	@Test
	void testGetCustomerById() {
		CustomerDto dto=customerClient.getCustomerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewCustomer() {
		CustomerDto dto = CustomerDto.builder().customerName("Swa").build();
		
		URI uri=customerClient.saveNewCustomer(dto);
		
		assertNotNull(uri);
		System.out.println(uri);
	}
	
	@Test
	void testUpdateCustomer() {
		CustomerDto dto=CustomerDto.builder().customerName("Swa").build();
		
		customerClient.updateCustomer(UUID.randomUUID(), dto);
	}

	@Test
	void testDeleteCustomer() {
		
		customerClient.deleteCustomer(UUID.randomUUID());
	}
}
