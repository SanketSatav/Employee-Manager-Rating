package com.cognizant.Test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Test.model.Employee;
import com.cognizant.Test.model.employeeRating;
import com.cognizant.Test.repository.EmpRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
    private EmpRepository empRepository;

    public EmployeeServiceImpl(EmpRepository empRepository){
        this.empRepository = empRepository; 
    }

    public boolean insertEmployeeDetails(Employee employee){
    	empRepository.save(employee);
        return true;
    }

	
	public List<Employee> getAllEmployees(){

		return empRepository.findAll();

	}

	@Override
	public void ratingEmployeeToManager(String emp_id, String mgr_id, String rating) {
		// TODO Auto-generated method stub
		empRepository.ratingEmployeeToManager(emp_id, mgr_id, rating);
	}

	@Override
	public void ratingManagerToEmployee(String mgr_id, String emp_id, String rating) {
		// TODO Auto-generated method stub
		empRepository.ratingManagerToEmployee(mgr_id, emp_id, rating);
		
	}
}
