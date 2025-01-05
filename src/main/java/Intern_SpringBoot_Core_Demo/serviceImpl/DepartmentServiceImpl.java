package Intern_SpringBoot_Core_Demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Intern_SpringBoot_Core_Demo.model.Department;
import Intern_SpringBoot_Core_Demo.repository.DepartmentRepository;
import Intern_SpringBoot_Core_Demo.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		deptRepo.deleteById(id);
		
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDept() {
		
		return deptRepo.findAll();
	}

}
