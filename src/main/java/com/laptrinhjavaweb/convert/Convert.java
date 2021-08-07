package com.laptrinhjavaweb.convert;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.EmployeeDTO;
import com.laptrinhjavaweb.entity.EmployeeEntity;
@Component
public class Convert {
	
	public EmployeeEntity toEntiy(EmployeeDTO employeeDto) {
		EmployeeEntity entity = new EmployeeEntity();
		//entity.setId(employeeDto.getId());
		entity.setFirstName(employeeDto.getFirstName());
		entity.setLastName(employeeDto.getLastName());
		entity.setStatus(employeeDto.getStatus());
		entity.setJob(employeeDto.getJob());
		return entity;
	}
	public EmployeeEntity toEntiy(EmployeeDTO employeeDto, EmployeeEntity employeeEntity) {
	
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setStatus(employeeDto.getStatus());
		employeeEntity.setJob(employeeDto.getJob());
		return employeeEntity;
	}
	public EmployeeDTO toDto(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDto = new EmployeeDTO();
		if(employeeEntity.getId() != null) {
			employeeDto.setId(employeeEntity.getId());
		}
		employeeDto.setFirstName(employeeEntity.getFirstName());
		employeeDto.setLastName(employeeEntity.getLastName());
		employeeDto.setStatus(employeeEntity.getStatus());
		employeeDto.setJob(employeeEntity.getJob());
		return employeeDto;
	}
}
