package com.example.ratingservice.service;

import java.util.List;

import com.example.ratingservice.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;


public interface RatingService {
	List<Employee> getAllEmployees() throws JsonMappingException, JsonProcessingException;
	
	public String getEmpRating(String id) throws JsonMappingException, JsonProcessingException;
 
	public String getMgrRating(String id) throws JsonMappingException, JsonProcessingException;
	
	

}
