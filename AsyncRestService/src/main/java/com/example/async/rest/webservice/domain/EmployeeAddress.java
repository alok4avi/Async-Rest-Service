package com.example.async.rest.webservice.domain;

public class EmployeeAddress {
	
	private Integer employeeId;
	
	private String address;
	
	public EmployeeAddress(Integer employeeId, String address) {
		super();
		this.employeeId = employeeId;
		this.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
