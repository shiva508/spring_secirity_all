package com.security.service.employee;

import java.util.List;

import com.security.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> employees();

}
