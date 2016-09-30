package util;

public class Address {

	private String address;
	private String neighborhood;
	private String city;
	private String cep;
	
	public Address(String address) {
		
	}
	
	public Address(String address, String neighborhood, 
							String city,String cep) {
		this.address = address;
		this.neighborhood = neighborhood;
		this.city = city;
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {	
		if(cep.length() > 8) {
			this.cep = cep;
		}
	}
}
