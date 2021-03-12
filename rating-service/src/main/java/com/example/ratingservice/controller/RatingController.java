package com.example.ratingservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingservice.model.Employee;
import com.example.ratingservice.service.RatingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class RatingController {

	@Autowired
	private RatingService service;
	
	
	public RatingController(RatingService service) {
		this.service = service;
	}
	
	@Value("${msg}")
	private String msg;
	@GetMapping("/msg")
	public String message() {
		return msg; 
	}
	
	
	@HystrixCommand(fallbackMethod = "getFallbackGetEmployee")
	@GetMapping("/")
	public List<Employee> getAllEmployees() throws JsonMappingException, JsonProcessingException{
		return service.getAllEmployees();
	
	}
	
	public List<Employee> getFallbackGetEmployee(){
		return Arrays.asList(new Employee("Null","No Name","No Desgnation","Null","Null","Null"));
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackEmployeeRating")
	@GetMapping("/emp/{emp_id}")
	public String getEmpRating(@PathVariable("emp_id") String emp_id) throws JsonMappingException, JsonProcessingException {
		return service.getEmpRating(emp_id); 
	}
	
	public String getFallbackEmployeeRating(@PathVariable("emp_id") String emp_id) {
		return "Bad Request, Can not calculate Employee Rating";
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackManagerRating")
	@GetMapping("/mgr/{emp_id}")
	public String getMgrRating(@PathVariable("emp_id") String emp_id) throws JsonMappingException, JsonProcessingException {
		return service.getMgrRating(emp_id);
	}
	
	public String getFallbackManagerRating(@PathVariable("emp_id") String emp_id) {
		return "Bad Request, Can not calculate Manager Rating";
	}
		
	
}
