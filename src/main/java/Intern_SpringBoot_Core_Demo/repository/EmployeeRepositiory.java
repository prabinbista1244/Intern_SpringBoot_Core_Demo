package Intern_SpringBoot_Core_Demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import Intern_SpringBoot_Core_Demo.model.Employee;

public interface EmployeeRepositiory extends JpaRepositoryImplementation<Employee, Integer>{

}
