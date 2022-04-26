package com.fdmgroup;

public class Librarian {
	private String name;
	private String address;
	private String position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Librarian(String name, String address, String position) {
		super();
		this.name = name;
		this.address = address;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Librarian [name=" + name + ", address=" + address + ", position=" + position + "]";
	}

}
