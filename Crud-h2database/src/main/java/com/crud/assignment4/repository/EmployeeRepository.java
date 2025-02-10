package com.wipro.assignment4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wipro.assignment4.entity.Employee;

@Repository
public class EmployeeRepository {
	 private final JdbcTemplate jdbcTemplate;

	    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    // Method to insert employee details into the database
	    public void insertEmployee(Employee employee) {
	        String sql = "INSERT INTO EMPLOYEE (emp_id, emp_name, emp_email, emp_location) VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(sql, 
	            employee.getEmpId(), 
	            employee.getEmpName(), 
	            employee.getEmpEmail(), 
	            employee.getEmpLocation());
	    }

	    // Method to get all employee details from the database
	    public List<Employee> getAllEmployees() {
	        String sql = "SELECT * FROM EMPLOYEE";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
	    }
	    
	    public Optional<Employee> findEmployeeById(Long empId) {
	        String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
	        try {
	            Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{empId},
	                    new BeanPropertyRowMapper<>(Employee.class));
	            return Optional.of(employee);
	        } catch (Exception e) {
	            // Handle the case when no employee is found for the given employeeId
	            return Optional.empty();
	        }
	    }
}
