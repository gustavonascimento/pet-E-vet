package model;

import util.Cpf;
import util.Email;
import util.Telephone;

public class Person {

	private String name;
	private Long code;
	private Cpf cpf;
	private Email email;
	private Telephone telephoneNumber;
	

	public Long getCode() {
		return code;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Telephone getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Telephone telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
