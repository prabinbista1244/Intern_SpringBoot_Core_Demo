package Intern_SpringBoot_Core_Demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Intern_SpringBoot_Core_Demo.model.User;
import Intern_SpringBoot_Core_Demo.repository.UserRepository;
import Intern_SpringBoot_Core_Demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User userLogin(String em, String psw) {
		
		
		return userRepo.findByEmailAndPassword(em,psw);
		
	}

	@Override
	public User checkSignup(String eml) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(eml);
	}

}
