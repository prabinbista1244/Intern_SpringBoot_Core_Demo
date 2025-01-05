package Intern_SpringBoot_Core_Demo.service;

import Intern_SpringBoot_Core_Demo.model.User;

public interface UserService {
	
	void userSignup(User user);
	User userLogin(String em,String psw);
	User checkSignup(String eml);

}
