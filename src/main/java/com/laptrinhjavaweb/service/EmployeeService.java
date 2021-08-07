package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.EmployeeDTO;
import com.laptrinhjavaweb.dto.EmployeeListDTO;

public interface EmployeeService {
	EmployeeDTO createOrUpdateEmployee(EmployeeDTO employeeDTO);

	String deleteEmployee(String firsrName);

	EmployeeDTO listDetail(String firstName);

	EmployeeListDTO allEmployee();

}
