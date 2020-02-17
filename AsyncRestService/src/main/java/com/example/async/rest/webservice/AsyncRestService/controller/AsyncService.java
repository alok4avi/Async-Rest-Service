package com.example.async.rest.webservice.AsyncRestService.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.async.rest.webservice.domain.Employee;
import com.example.async.rest.webservice.domain.EmployeeAddress;
import com.example.async.rest.webservice.domain.EmployeeContact;

@Service
public class AsyncService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<Employee> getEmployeeName(String id) throws InterruptedException{
		logger.info("getEmployeeName starts");
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		
		Employee employee = restTemplate.getForObject("http://localhost:8080/emp/name/{id}", Employee.class, params);
		
		logger.info("Employee Name {}", employee);
		
		Thread.sleep(1000L);
		logger.info("getEmployeeName completed");
		return CompletableFuture.completedFuture(employee);
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddress> getEmployeeAddress(String id) throws InterruptedException{
		logger.info("getEmployeeAddress starts");
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);		
		EmployeeAddress employee = restTemplate.getForObject("http://localhost:8080/emp/address/{id}", 
				EmployeeAddress.class, params);
		
		logger.info("EmployeeAddress {}", employee);
		
		Thread.sleep(1000L);
		logger.info("getEmployeeAddress completed");
		return CompletableFuture.completedFuture(employee);
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeContact> getEmployeeContact(String id) throws InterruptedException{
		logger.info("getEmployeeContact starts");
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);	
		EmployeeContact employee = restTemplate.getForObject("http://localhost:8080/emp/contact/{id}", EmployeeContact.class);
		
		logger.info("EmployeeContact  {}", employee);
		
		Thread.sleep(1000L);
		logger.info("getEmployeeContact completed");
		return CompletableFuture.completedFuture(employee);
	}

}
