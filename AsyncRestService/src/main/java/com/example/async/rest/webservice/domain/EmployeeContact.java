package com.example.async.rest.webservice.domain;

public class EmployeeContact {
	
	private Integer employeeId;
	
	private String emailId;
	
	private String phoneNumber;

	public EmployeeContact(Integer employeeId, String emailId, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
