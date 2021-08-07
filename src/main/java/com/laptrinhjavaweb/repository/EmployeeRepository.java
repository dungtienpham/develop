package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	@Query(value = "SELECT * FROM Employee where first_name = :firstName", nativeQuery = true)
	EmployeeEntity findByFirstName(@Param("firstName") String firstName);
}
