package com.laptrinhjavaweb.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.laptrinhjavaweb.dto.EmployeeDTO;
import com.laptrinhjavaweb.dto.EmployeeListDTO;
import com.laptrinhjavaweb.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmployee(
			@RequestBody @Valid EmployeeDTO employeeDTO) throws URISyntaxException {
		EmployeeDTO emploDto = employeeService.createOrUpdateEmployee(employeeDTO);
		return ResponseEntity.created(new URI("create-update")).body(emploDto);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(
			@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable("id") long id) throws URISyntaxException {
		employeeDTO.setId(id);
		EmployeeDTO emploDto = employeeService.createOrUpdateEmployee(employeeDTO);
		return ResponseEntity.created(new URI("create-update")).body(emploDto);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCard(@RequestParam(required = true) String firstName) {
		String result = employeeService.deleteEmployee(firstName);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/detail")
	public ResponseEntity<EmployeeDTO> employeeDetail(@RequestParam(required = true) String firstName) {
		EmployeeDTO employeeResponse = employeeService.listDetail(firstName);
		return ResponseEntity.ok().body(employeeResponse);
	}

	@GetMapping("/list")
	public ResponseEntity<EmployeeListDTO> allDeactiveCard() {
		EmployeeListDTO allDeactive = employeeService.allEmployee();
		return ResponseEntity.ok().body(allDeactive);
	}
}
