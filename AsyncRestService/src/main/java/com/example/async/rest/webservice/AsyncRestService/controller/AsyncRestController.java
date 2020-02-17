package com.example.async.rest.webservice.AsyncRestService.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.rest.webservice.domain.Employee;
import com.example.async.rest.webservice.domain.EmployeeAddress;
import com.example.async.rest.webservice.domain.EmployeeContact;


@RestController
public class AsyncRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AsyncService service;
	
	@GetMapping("/testAsync/{id}")
	public void getEmplyDetails(@PathVariable String id) throws InterruptedException, ExecutionException {
		
		logger.info("Test Async starts");
		
		CompletableFuture<Employee> employee = service.getEmployeeName(id);
		CompletableFuture<EmployeeAddress> employeeAddress = service.getEmployeeAddress(id);
		CompletableFuture<EmployeeContact> employeeContact = service.getEmployeeContact(id);
		
		CompletableFuture.allOf(employee, employeeAddress, employeeContact).join();
		
		logger.info("Employee name : {}" + employee.get());
		logger.info("Employee Address : {}" + employeeAddress.get());
		logger.info("Employee Contact : {}" + employeeContact.get());
		
		logger.info("Test Async end");
		
	}
	
//	@GetMapping("/hello-world-bean")
//	public HelloWorldBean helloWorldBean() {
//		return new HelloWorldBean("Welcome to the world!");
//		
//	}

}
