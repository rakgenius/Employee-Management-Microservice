package com.rakeshv.employeesearchservice.models;

/**
 * EmployeeType
 */
public enum EmployeeType {
    EMPLOYEE("employee"),
    VISITOR("visitor")
    ;
    
    private String employeeType;

    private EmployeeType(String type) {
        this.employeeType = type;
    }

    public String getEmployeeType() {
        return employeeType;
    }
}