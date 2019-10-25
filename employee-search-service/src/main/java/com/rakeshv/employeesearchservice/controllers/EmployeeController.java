package com.rakeshv.employeesearchservice.controllers;

import java.util.List;
import java.util.Optional;

import com.rakeshv.employeesearchservice.models.Employee;
import com.rakeshv.employeesearchservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * EmployeeController
 */
@RestController
@RefreshScope
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
        Optional<Employee> optional = employeeService.findEmployeeByName(name);
        if (optional.isPresent()) {
            return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}