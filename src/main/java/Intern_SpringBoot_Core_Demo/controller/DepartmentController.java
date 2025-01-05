package Intern_SpringBoot_Core_Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Intern_SpringBoot_Core_Demo.model.Department;
import Intern_SpringBoot_Core_Demo.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/getDepartment")
	public String getDepartment() {
		
		return "DepartmentForm";
	}
	
	
	@PostMapping("/postDepartment")
	public String postDepartment(@ModelAttribute Department dept, Model m) {
		
		deptService.addDept(dept);
		
		return "DepartmentForm";
		
	}
	
	
	@GetMapping("/getDepartmentList")
	public String getDepartmentList(Model model) {
		
		model.addAttribute("dList", deptService.getAllDept());
		
		return "DepartmentList";
	}
	
	
	
	@GetMapping("/dept/delete")
	public String getDeleteDepartment(@RequestParam int id) {
		
		deptService.deleteDept(id);
		
		return "redirect:/getDepartmentList";
		
	}
	
	
	
	
	
	
	@GetMapping("/dept/edit")
	public String editDepartment(@RequestParam int id,Model model) {
		
		model.addAttribute("dModel", deptService.getDeptById(id));
		
		return "DepartmentEditForm";
	}
	
	
	@PostMapping("/dept/update")
	public String postEditDepartment(@ModelAttribute Department dept) {
		
		deptService.updateDept(dept);
		
		return "redirect:/getDepartmentList";
	}

}
