package com.rakeshv.employeedashboardservice.controllers;

import java.util.List;

import com.rakeshv.employeedashboardservice.feign.EmployeeServiceProxy;
import com.rakeshv.employeedashboardservice.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeFeignController
 */
@RestController
@RefreshScope
@RequestMapping("/dashboard")
public class EmployeeFeignController {
    @Autowired
    private EmployeeServiceProxy proxy;
    
    @GetMapping("/feign/{name}")
    public Employee findEmployee(@PathVariable("name") String name) {
        return proxy.findByname(name);
    }

    @GetMapping("/feign/all")
    public List<Employee> findAll() {
        return proxy.findAll();
    }
}