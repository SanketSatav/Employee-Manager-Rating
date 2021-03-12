package com.cognizant.Test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.Test.model.Employee;

@Component
public interface EmployeeDao {

public List<Employee> getAllEmployees();
public boolean insertEmployeeDetails(Employee employee);	


}
