package Intern_SpringBoot_Core_Demo.service;

import java.util.List;

import Intern_SpringBoot_Core_Demo.model.Department;

public interface DepartmentService {
	void addDept(Department dept);
	void deleteDept(int id);
	void updateDept(Department dept);
	Department getDeptById(int id);
	List<Department> getAllDept();

}
