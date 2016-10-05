package model;

public class Employee extends Person {
	
	private String employeeRole;

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	@Override
	public String toString() {
		return "Employee [code=" + getCode() + ", name=" + getName() +
				", cpf=" + getCpf().getCpf() + ", email=" + getEmail().getEmail() + ", telephone" + 
				getTelephone().getTelephone() + ", role=" + getEmployeeRole() + "]";
	}
	
}
