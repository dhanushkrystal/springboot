package com.wipro.assignment5.model;

public class Employee {
	 private Long empId;
	    private String empName;
	    private String empEmail;
	    private String empLocation;
	    
	    public Employee() {}
	    
		public Employee(Long empId, String empName, String empEmail, String empLocation) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empEmail = empEmail;
			this.empLocation = empLocation;
		}
		public Long getEmpId() {
			return empId;
		}
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empLocation="
					+ empLocation + "]";
		}
		public void setEmpId(Long empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getEmpEmail() {
			return empEmail;
		}
		public void setEmpEmail(String empEmail) {
			this.empEmail = empEmail;
		}
		public String getEmpLocation() {
			return empLocation;
		}
		public void setEmpLocation(String empLocation) {
			this.empLocation = empLocation;
		}
}
