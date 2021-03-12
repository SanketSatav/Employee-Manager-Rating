package com.cognizant.Test.service;

import java.util.List;


import com.cognizant.Test.model.Employee;

public interface EmployeeService{
	boolean insertEmployeeDetails(Employee employee);
	List<Employee> getAllEmployees();
	
	void ratingEmployeeToManager(String emp_id, String mgr_id, String rating);
	void ratingManagerToEmployee(String mgr_id, String emp_id, String rating);
}



