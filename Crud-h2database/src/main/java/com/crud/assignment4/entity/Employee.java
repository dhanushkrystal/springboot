package com.wipro.assignment4.entity;

public class Employee {
	 private Long empId;
	    private String empName;
	    private String empEmail;
	    private String empLocation;
	    
	    public Employee() {}
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empLocation="
					+ empLocation + "]";
		}

		public Long getEmpId() {
			return empId;
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

		public Employee(Long empId, String empName, String empEmail, String empLocation) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empEmail = empEmail;
			this.empLocation = empLocation;
		}
}
