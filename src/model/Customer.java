package model;


import model.Animal;
import util.Address;

public class Customer extends Person {

	private String date_of_birth;
	private Address address;
 	private Animal animal;

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
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
				getTelephone().getTelephone() + ", date_of_birth" + date_of_birth +
				", address" + getAddress().getAddress() + ", neighborhood" + getAddress().getNeighborhood() +
				", city" + getAddress().getCity() + ", cep" + getAddress().getCep() + "]";
	}
}
