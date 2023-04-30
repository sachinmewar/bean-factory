package org.spring.service;

import org.spring.model.Employee;

public class EmployeeService {
    Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployeeDetails() {
        return employee;
    }
}
