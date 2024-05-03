package com.example.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mongo.entity.Employee;
import com.example.mongo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	 private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;
	
		//to get the index page
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		//to get the html page to add an employee
		@GetMapping("/addEmployee")
		public String addEmployee() {
			return "addEmployee";
		}
		
		//to get the html page to find an employee
		@GetMapping("/findEmployee")
		public String findEmp() {
			return "findEmp";
		}
		
		//to get the list of employees 
		@GetMapping(value="/listOfEmployee")
		public String getAllEmployee(Model model) {
			List<Employee> employee=empService.getemployeeList();
			model.addAttribute("employee", employee);
			return "displayEmployee";
		}
		
		//Creating a post method to save the employee details
		@PostMapping(value="/submitEmployee")
		public String addEmployee(@ModelAttribute Employee employee) {
			empService.saveEmployee(employee);
			//redirect to display page after adding the product
			return "redirect:/";
		}
		
		//to search for an Employee by using emp id
		@GetMapping("/findEmp")
		public String findEmployee(@RequestParam int id, Model model) {
			System.out.println("Calling the controller");
			Optional<Employee> employee = empService.findEmployee(id);	
			if(employee.isEmpty()) {
				model.addAttribute("error", "Employee you have searched is not available");
				return "error";
			} else {
				model.addAttribute("employee", employee.get());
				return "displayEmployee";
			}
			
		}
}
