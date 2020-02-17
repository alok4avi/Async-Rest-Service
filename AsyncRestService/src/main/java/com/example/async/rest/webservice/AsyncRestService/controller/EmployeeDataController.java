package com.example.async.rest.webservice.AsyncRestService.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.rest.webservice.domain.Employee;
import com.example.async.rest.webservice.domain.EmployeeAddress;
import com.example.async.rest.webservice.domain.EmployeeContact;

@RestController
public class EmployeeDataController {
	
	private static Logger logger= LoggerFactory.getLogger(EmployeeDataController.class);
	
	@GetMapping(value ="/emp/address/{id}")
	public EmployeeAddress getAddress(@PathVariable String id){
		logger.info("Getting Employee Address");
		EmployeeAddress address1 = new EmployeeAddress(1001, "XYZ Street1");
		EmployeeAddress address2 = new EmployeeAddress(1002, "XYZ Street2");
		EmployeeAddress address3 = new EmployeeAddress(1003, "XYZ Street3");
		List<EmployeeAddress> empAddressList = new ArrayList<EmployeeAddress>();
		empAddressList.add(address1);
		empAddressList.add(address2);
		empAddressList.add(address3);
		
		for(EmployeeAddress temp : empAddressList){
			if(temp.getEmployeeId().equals(id)){
				return temp;
			}
		}
		return null;
	}
	
	@GetMapping(value ="/emp/name/{id}")
	public Employee getName(@PathVariable String id){
		logger.info("Getting Employee Name");
		Employee employee1 = new Employee(1001, "Alok", "Mishra1");
		Employee employee2 = new Employee(1002, "Alok", "Mishra2");
		Employee employee3 = new Employee(1003, "Alok", "Mishra3");
		List<Employee> empNameList = new ArrayList<Employee>();
		empNameList.add(employee1);
		empNameList.add(employee2);
		empNameList.add(employee3);
		
		for(Employee temp : empNameList){
			if(temp.getEmployeeId().equals(id)){
				return temp;
			}
		}
		return null;
	}
	
	@GetMapping(value ="/emp/contact/{id}")
	public EmployeeContact getContact(@PathVariable String id){
		logger.info("Getting Employee Contacts");
		EmployeeContact empContact1 = new EmployeeContact(1001, "abc@gmail.com", "9999221698");
		EmployeeContact empContact2 = new EmployeeContact(1002, "abc@gmail.com", "9999221699");
		EmployeeContact empContact3 = new EmployeeContact(1002, "abc@gmail.com", "9999221690");
		List<EmployeeContact> contactList = new ArrayList<EmployeeContact>();
		contactList.add(empContact1);
		contactList.add(empContact2);
		contactList.add(empContact3);
		
		for(EmployeeContact temp : contactList){
			if(temp.getEmployeeId().equals(id)){
				return temp;
			}
		}
		return null;
	}

}
