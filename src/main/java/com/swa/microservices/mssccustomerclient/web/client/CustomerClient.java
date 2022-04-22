package com.swa.microservices.mssccustomerclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.swa.microservices.mssccustomerclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(value="sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

	private String CUSTOMER_PATH_V1="/api/v1/customer/";
	
	private String apihost;
	private final RestTemplate restTemplate;

	public void setApihost(String apihost) {
		this.apihost = apihost;
	}

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public CustomerDto getCustomerById(UUID id) {
		
		return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), CustomerDto.class);
	}
	
	public URI saveNewCustomer(CustomerDto dto) {
		
		return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, dto);
	}
	
	public void updateCustomer(UUID id, CustomerDto dto) {
		
		restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + id.toString() , dto);
	}
	
	public void deleteCustomer(UUID id) {
		
		restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + id);
	}
}
