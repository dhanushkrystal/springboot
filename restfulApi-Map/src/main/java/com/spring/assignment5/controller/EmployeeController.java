package com.wipro.assignment5.controller;

import java.util.Map;
import java.util.Map.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.assignment5.model.Employee;
import com.wipro.assignment5.repository.EmployeeRespository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
    private EmployeeRespository employeeRepository;

    // GET all employees
    @GetMapping
    public Map<Long, Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    // GET employee by ID
    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId) {
        return employeeRepository.findEmployeeById(empId).orElse(null); // Return null if employee not found
    }

    // POST to add a new employee
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    // PUT to update an existing employee
    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable Long empId, @RequestBody Employee updatedEmployee) {
        return employeeRepository.updateEmployee(empId, updatedEmployee);
    }

    // DELETE an employee by ID
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable Long empId) {
        return employeeRepository.deleteEmployee(empId);
    }
}
