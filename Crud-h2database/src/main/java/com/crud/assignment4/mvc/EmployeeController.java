package com.wipro.assignment4.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.assignment4.entity.Employee;
import com.wipro.assignment4.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/index")
    public String showForm() {
        return "index"; 
    }
	
	@PostMapping("/submitEmployee")
    public String submitEmployee(Employee employee, Model model) {
        employeeRepository.insertEmployee(employee);
        model.addAttribute("message", "Employee details submitted successfully!");
        return "employeedetails"; // Return a view that will show the confirmation message
    }
	@GetMapping("/display/{empId}")
    public String displayEmployee(@PathVariable Long empId, Model model) {
        Optional<Employee> employee = employeeRepository.findEmployeeById(empId);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "empid"; // View name to show employee details
        } else {
            
            return "error"; // View for error page if employee not found
        }
    }
	 
	 
	    }
	

