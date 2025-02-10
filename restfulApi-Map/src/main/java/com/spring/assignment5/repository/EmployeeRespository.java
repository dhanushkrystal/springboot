package com.wipro.assignment5.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.wipro.assignment5.model.Employee;

@Repository
public class EmployeeRespository {
	
	private Map<Long, Employee> employeeMap = new HashMap<>();

    // Save or add employee to the map
    public String addEmployee(Employee employee) {
        employeeMap.put(employee.getEmpId(), employee);
        return "Employee added successfully!";
    }

    // Get all employees
    public Map<Long, Employee> getAllEmployees() {
        return employeeMap;
    }

    // Get employee by ID
    public Optional<Employee> findEmployeeById(Long empId) {
        return Optional.ofNullable(employeeMap.get(empId));
    }

    // Update employee details
    public String updateEmployee(Long empId, Employee updatedEmployee) {
        if (employeeMap.containsKey(empId)) {
            Employee existingEmployee = employeeMap.get(empId);
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmpEmail(updatedEmployee.getEmpEmail());
            existingEmployee.setEmpLocation(updatedEmployee.getEmpLocation());
            return "Employee updated successfully!";
        } else {
            return "Employee not found!";
        }
    }

    // Delete an employee
    public String deleteEmployee(Long empId) {
        if (employeeMap.containsKey(empId)) {
            employeeMap.remove(empId);
            return "Employee deleted successfully!";
        } else {
            return "Employee not found!";
        }
    }
}
