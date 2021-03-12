package com.cognizant.Test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Test.dao.EmployeeDao;
import com.cognizant.Test.dao.EmployeeDaoImpl;
import com.cognizant.Test.model.Employee;
import com.cognizant.Test.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class EmployeeController {


	
	@Autowired
	private EmployeeService employeeser;

	public EmployeeController(EmployeeService employeeser){
		this.employeeser = employeeser;
	}

	@HystrixCommand(fallbackMethod = "getFallbackGetEmployee")
	@GetMapping("/")
	public List<Employee> getAllEmployees(){
		return employeeser.getAllEmployees();
	}
	
	public List<Employee> getFallbackGetEmployee(){
		return Arrays.asList(new Employee("Null","No Name","No Desgnation","Null","Null","Null"));
	}

	@HystrixCommand(fallbackMethod = "getFallbackAddEmployee")
	@PostMapping("/add")
	public boolean insertEmployee(@RequestBody Employee employee){
		return employeeser.insertEmployeeDetails(employee);
	}
	
	public boolean getFallbackAddEmployee(@RequestBody Employee employee) {
		return false;
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackratingEmployeeToManager")
	@GetMapping("/emp/mgr/{emp_id}/{mgr_id}/{rating}")
	public void ratingEmployeeToManager(@PathVariable("emp_id") String emp_id,@PathVariable("mgr_id") String mgr_id, @PathVariable String rating) {
		employeeser.ratingEmployeeToManager(emp_id, mgr_id, rating);
		//return true;
	}
	
	public void getFallbackratingEmployeeToManager(@PathVariable("emp_id") String emp_id,@PathVariable("mgr_id") String mgr_id, @PathVariable String rating) {
		//Nothing Here
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackratingManagerToEmployee")
	@GetMapping("/mgr/emp/{mgr_id}/{emp_id}/{rating}")
	public void ratingManagerToEmployee(@PathVariable("mgr_id") String mgr_id,@PathVariable("emp_id") String emp_id, @PathVariable String rating) {
		employeeser.ratingManagerToEmployee(mgr_id, emp_id, rating);
		//return true;
	}

public void getFallbackratingManagerToEmployee(@PathVariable("emp_id") String emp_id,@PathVariable("mgr_id") String mgr_id, @PathVariable String rating) {
		//Nothing Here
	}

}
