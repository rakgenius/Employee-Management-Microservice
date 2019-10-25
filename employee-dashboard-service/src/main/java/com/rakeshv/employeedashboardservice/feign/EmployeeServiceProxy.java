package com.rakeshv.employeedashboardservice.feign;

import java.util.List;

import com.rakeshv.employeedashboardservice.model.Employee;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * EmployeeServiceProxy
 */
@FeignClient(name = "employee-search-service")
@RibbonClient(name = "employee-search-service")
public interface EmployeeServiceProxy {
    @GetMapping("/employee/name/{name}")
    public Employee findByname(@PathVariable("name") String name);

    @GetMapping("/employee/findall")
    public List<Employee> findAll();
    
}