package Intern_SpringBoot_Core_Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Intern_SpringBoot_Core_Demo.model.Employee;
import Intern_SpringBoot_Core_Demo.service.DepartmentService;
import Intern_SpringBoot_Core_Demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/getEmployee")
	public String getEmployee(Model model) {
		
		model.addAttribute("fromEmpControllerDList", deptService.getAllDept());
		return "EmployeeForm";
	}
	
	
	@PostMapping("/postEmployee")
	public String postEmployee(@ModelAttribute Employee emp) {
		
		empService.addEmployee(emp);
		return "EmployeeForm";
	}
	
	
	@GetMapping("/getEmployeeList")
	public String getEmployeeList(Model model) {
		
		model.addAttribute("eList", empService.getAllEmployee());
		
		return "EmployeeList";
		
	}
	
	@GetMapping("/emp/edit")
	public String getEidiEmployee(@RequestParam int id, Model model ) {
		
		model.addAttribute("eModel", empService.getEmployeeById(id));
		
		return "EmployeeEditForm";
	}
	
	
	@PostMapping("/emp/update")
	public String postEditEmployee(@ModelAttribute Employee emp) {
		
		empService.updateEmployee(emp);
		
		return "redirect:/getEmployeeList";
	}
	
	
	@GetMapping("/emp/delete")
	public String getDeleteEmployee(@RequestParam int id) {
		
		empService.deleteEmployee(id);
		
		return "redirect:/getEmployeeList";
	}
	

}
