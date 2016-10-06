package model;

public class Employee extends Person {

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Employee [code=" + getCode() + ", name=" + getName() +
				", cpf=" + getCpf().getCpf() + ", email=" + getEmail().getEmail() + ", telephone" + 
				getTelephone().getTelephone() + ", role=" + getRole() + "]";
	}
	
}
