package Intern_SpringBoot_Core_Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Intern_SpringBoot_Core_Demo.model.User;
import Intern_SpringBoot_Core_Demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping({"/","/Getlogin"})
	public String getLogin() {
		
		return "LoginForm";
	}
	
	
	
	@PostMapping("/postLogin")
	public String postLogin(@ModelAttribute User user, Model m) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = userService.userLogin(user.getEmail(), user.getPassword());
		
		if(u != null) {
			m.addAttribute("name", u.getName());
			return "Home";
		}
		
		m.addAttribute("message", "user not found, so try again !");
		return "LoginForm";
	}
	
	
	
	@GetMapping("/GetSignUP")
	public String getSignUp() {
		
		return "SignUpForm";	
		
	}
	
	@PostMapping("/postSignUp")
	public String postSignUp(@ModelAttribute User u, Model m) {
		
		// check is the user already exist?
		User us = userService.checkSignup(u.getName());
		
		System.out.println("result:" + us);
		
		if(us == null) {
	
			//u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
			userService.userSignup(u);
			return "Home";
		}
		
		m.addAttribute("message", "this user is already exist !");
		return "SignUpForm";
			
		
		
	}
	
	
	@GetMapping("/getLogout")
	public String logout() {
		
		return "LoginForm";
	}
}
