package com.rakeshv.employeesearchservice.service;

import java.util.List;
import java.util.Optional;

import com.rakeshv.employeesearchservice.models.Employee;
import com.rakeshv.employeesearchservice.models.EmployeeType;
import com.rakeshv.employeesearchservice.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * EmployeeService
 */
@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByNameEqualsIgnoreCase(name);
    }

    public Optional<Employee> findEmployeeByPhone(String phone) {
        return employeeRepository.findByPhoneEqualsIgnoreCase(phone);
    }

    public Optional<Employee> getEmployeeByType(String type) {
        return employeeRepository.findByEmployeeType(type);
    }
}