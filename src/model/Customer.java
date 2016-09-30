package model;


import model.Animal;
import util.Address;

public class Customer extends Person {

	private String dateOfBirth;
	private Address address;
 	private Animal animal;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString(){
		return "Customer [code=" + getCode() + ", name=" + getName() +
				", cpf=" + getCpf().getCpf() + ", email=" + getEmail().getEmail() + ", telephone" + 
				getTelephoneNumber().getTelephoneNumber() + ", date_of_birth" + dateOfBirth +
				", address" + getAddress().getAddress() + ", neighborhood" + getAddress().getNeighborhood() +
				", city" + getAddress().getCity() + ", cep" + getAddress().getCep() + "]";
	}
}
