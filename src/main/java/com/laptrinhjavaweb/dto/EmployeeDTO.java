package com.laptrinhjavaweb.dto;

public class EmployeeDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String status;
	private String job;

	public EmployeeDTO() {
	}
	

	public EmployeeDTO(Long id, String firstName, String lastName, String status, String job) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.job = job;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	

}
