package Intern_SpringBoot_Core_Demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import Intern_SpringBoot_Core_Demo.model.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Integer>{
	
	User findByEmailAndPassword(String em,String paw);
	User findByEmail(String eml);
}
