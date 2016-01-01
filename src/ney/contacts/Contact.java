package ney.contacts;

public class Contact implements Comparable<Contact> {

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

	@Override
	public int compareTo(Contact contact) {
		String a = this.getName();
		String b = contact.getName();
		String[] arraya = a.split(" ");
		String[] arrayb = b.split(" ");
		String aLast;
		String bLast;

		if (arraya[arraya.length - 1].matches("[IVX]*") || arraya[arraya.length - 1].equals("Jr")
				|| arraya[arraya.length - 1].equals("Sr")) {
			aLast = arraya[arraya.length - 2];
		} else {
			aLast = arraya[arraya.length - 1];
		}
		if (arrayb[arrayb.length - 1].matches("[IVX]*") || arrayb[arrayb.length - 1].equals("Jr")
				|| arrayb[arrayb.length - 1].equals("Sr")) {
			bLast = arrayb[arrayb.length - 2];
		} else {
			bLast = arrayb[arrayb.length - 1];
		}
		return aLast.compareTo(bLast);
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
