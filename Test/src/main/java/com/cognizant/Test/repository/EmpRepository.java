package com.cognizant.Test.repository;
import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Test.model.Employee;

@Transactional
public interface EmpRepository extends JpaRepository<Employee,Integer> {
	
	@Modifying
	@Query(value= "UPDATE employee emp SET emp.rating_B = ?3 WHERE emp.emp_id = ?2 AND emp.mgr_id = ?1",nativeQuery = true)
	void ratingManagerToEmployee(String mgr_id, String emp_id, String rating);
	
	@Modifying
	@Query(value= "UPDATE employee emp SET emp.rating_A = ?3 WHERE emp.emp_id = ?1 AND emp.mgr_id = ?2",nativeQuery = true)
	void ratingEmployeeToManager(String emp_id, String mgr_id, String rating);
	
	
	

}
