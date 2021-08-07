package com.laptrinhjavaweb.dto;

import java.util.List;

public class EmployeeListDTO {
	private List<EmployeeDTO> list;

	public EmployeeListDTO() {
		super();
	}

	public EmployeeListDTO(List<EmployeeDTO> list) {
		super();
		this.list = list;
	}

	public List<EmployeeDTO> getList() {
		return list;
	}

	public void setList(List<EmployeeDTO> list) {
		this.list = list;
	}

}
