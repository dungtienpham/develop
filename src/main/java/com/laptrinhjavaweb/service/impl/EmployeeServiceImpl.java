package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.controller.BusinessException;
import com.laptrinhjavaweb.convert.Convert;
import com.laptrinhjavaweb.dto.EmployeeDTO;
import com.laptrinhjavaweb.dto.EmployeeListDTO;
import com.laptrinhjavaweb.entity.EmployeeEntity;
import com.laptrinhjavaweb.repository.EmployeeRepository;
import com.laptrinhjavaweb.service.EmployeeService;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private Convert convert;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeeDTO createOrUpdateEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		if (employeeDTO.getLastName() != null && employeeDTO.getJob() != null && employeeDTO.getJob() != null
				&& employeeDTO.getStatus() != null) {
			if ((employeeDTO.getLastName().equals("Y") || employeeDTO.getLastName().equals("N"))
					&& (employeeDTO.getJob().equals("Y") || employeeDTO.getJob().equals("N"))
					&& (employeeDTO.getStatus().equals("Y") || employeeDTO.getStatus().equals("N"))) {
				if (employeeDTO.getId() != null) {
					EmployeeEntity emploEntityOld = employeeRepository.findOne(employeeDTO.getId());
					employeeEntity = convert.toEntiy(employeeDTO, emploEntityOld);
				} else {
					EmployeeEntity emploEntityExit = employeeRepository.findByFirstName(employeeDTO.getFirstName());
					if (emploEntityExit != null) {
						throw new BusinessException("409", "DUPLICATE", "FirstName da ton tai");
					} else {
						employeeEntity = convert.toEntiy(employeeDTO);
					}
				}
			} else {
				throw new BusinessException("400", "BAD REQUEST", "chon 'Y' hoac 'N' ");
			}
		}

		employeeEntity = employeeRepository.save(employeeEntity);

		return convert.toDto(employeeEntity);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String deleteEmployee(String firsrName) {
		EmployeeEntity employeeEntity = employeeRepository.findByFirstName(firsrName);
		if(employeeEntity != null) {
			employeeRepository.delete(employeeEntity);
			return "Delete thành công";
		}
		throw new BusinessException("404","NOT FOUND","Không có dữ liệu xóa");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeeDTO listDetail(String firstName) {
		EmployeeEntity employeeEntity = employeeRepository.findByFirstName(firstName);
		if(employeeEntity != null) {
			return convert.toDto(employeeEntity);
		}
		throw new BusinessException("404","NOT FOUND","Không tìm thấy dữ liệu");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeeListDTO allEmployee() {
		List<EmployeeDTO> list= new ArrayList<>();
		List<EmployeeEntity> listEmployee= employeeRepository.findAll();
		for(EmployeeEntity employe : listEmployee) {
			EmployeeDTO employeeDTO = convert.toDto(employe);
		    list.add(employeeDTO);
		}
		EmployeeListDTO employeeResponse = new EmployeeListDTO();
		employeeResponse.setList(list);
		return employeeResponse;
	}

}
