package model;

public class Customer {
	private String id;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	public Customer(String id, String name, String address, String phone, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;	
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
}