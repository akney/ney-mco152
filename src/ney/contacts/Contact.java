package ney.contacts;

public class Contact {

	private String name;
	private String email;
	private Address address;
	private String phone;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

}

class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

}
