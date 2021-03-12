package com.example.ratingservice.service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ratingservice.model.Employee;
import com.example.ratingservice.model.employeeRating;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaNamespace;

@Service
public class RatingServiceImpl implements RatingService  {

	@Autowired
	RestTemplate restTemplate;	
	@Value("${data.service.url}")
	private String DataServiceURL;
	
	@Override
	public List<Employee> getAllEmployees() throws JsonMappingException, JsonProcessingException {

	
		String jsonString = restTemplate.getForObject(DataServiceURL, String.class);

		ObjectMapper mapper = new ObjectMapper();
	
		List<Employee> EmployeeObjectList = mapper.readValue(jsonString, new TypeReference<List<Employee>>(){});
		return EmployeeObjectList;
	}


	@Override
	public String getEmpRating(String id) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		String jsonString = restTemplate.getForObject(DataServiceURL, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<Employee> EmployeeObjectList = mapper.readValue(jsonString, new TypeReference<List<Employee>>(){});

		
		double fromMgr = 0;
		boolean flag = false;
		for(Employee emp : EmployeeObjectList) {
			if(emp.getEmp_id().equalsIgnoreCase(id)) {
				 fromMgr = Integer.parseInt(emp.getRating_B());
				 flag =true;
			}
		}
		if(flag)
			return ("Rating Of Employee : " + id +" : = " +  (fromMgr));
		else
			return "Emplyee "+ id + " dose not exist";
	}

	@Override
	public String getMgrRating(String id) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		String jsonString = restTemplate.getForObject(DataServiceURL, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<Employee> EmployeeObjectList = mapper.readValue(jsonString, new TypeReference<List<Employee>>(){});
		
		
		double fromMgr = 0;
		boolean flag1 = false;
		for(Employee emp : EmployeeObjectList) {
			if(emp.getEmp_id().equalsIgnoreCase(id)) {
				 fromMgr = Integer.parseInt(emp.getRating_B());
				 flag1 = true;
			}
		}
		
		if(flag1) {
			int sum = 0;
			int cnt = 0;
			for(Employee emp : EmployeeObjectList) {
				if(emp.getMgr_id()!= null && emp.getMgr_id().equalsIgnoreCase(id)) {
					sum += Integer.parseInt(emp.getRating_A());
					cnt +=1;
				}
			}
			double fromEmp = sum/cnt;
			
			
			double finalRating = (fromMgr + fromEmp)/2;
			String result = Double.toString(finalRating);
			return ("Rating Of Manager : " + id +" : = " +  result);
		}
		else {
			return "Emplyee " + id + " dose not exist";
		}
	}

}
