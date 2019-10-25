package com.rakeshv.employeesearchservice.repository;

import java.util.Optional;

import com.rakeshv.employeesearchservice.models.Employee;
import com.rakeshv.employeesearchservice.models.EmployeeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByNameEqualsIgnoreCase(String name);
    Optional<Employee> findByPhoneEqualsIgnoreCase(String phone);
    Optional<Employee> findByEmployeeType(String type);
    
}