package com.example.ratingservice.model;

public class Employee {

	private String emp_id;
	private String emp_name;
	private String emp_designation;
	private String mgr_id;
	private String rating_A;
	private String rating_B;
	
	public Employee(String emp_id, String emp_name, String emp_designation, String mgr_id, String rating_A,
			String rating_B) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_designation = emp_designation;
		this.mgr_id = mgr_id;
		this.rating_A = rating_A;
		this.rating_B = rating_B;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public String getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getRating_A() {
		return rating_A;
	}
	public void setRating_A(String rating_A) {
		this.rating_A = rating_A;
	}
	public String getRating_B() {
		return rating_B;
	}
	public void setRating_B(String rating_B) {
		this.rating_B = rating_B;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_designation=" + emp_designation
				+ ", mgr_id=" + mgr_id + ", rating_A=" + rating_A + ", rating_B=" + rating_B + "]";
	}
	
	
}
