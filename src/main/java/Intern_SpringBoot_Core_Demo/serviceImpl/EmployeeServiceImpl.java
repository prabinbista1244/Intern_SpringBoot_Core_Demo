package Intern_SpringBoot_Core_Demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Intern_SpringBoot_Core_Demo.model.Employee;
import Intern_SpringBoot_Core_Demo.repository.EmployeeRepositiory;
import Intern_SpringBoot_Core_Demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepositiory empRepo;

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
