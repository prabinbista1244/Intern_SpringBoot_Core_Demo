package Intern_SpringBoot_Core_Demo.service;

import java.util.List;

import Intern_SpringBoot_Core_Demo.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee emp);
	public void deleteEmployee(int id);
	public void updateEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployee();
	
	

}
