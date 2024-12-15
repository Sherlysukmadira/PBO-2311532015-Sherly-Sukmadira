package model;

public class CustomerBuilder {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	
	public CustomerBuilder() {
		
	}
	
	public CustomerBuilder setId(String id) {
		this.id = id;
		return this;}
	
	public CustomerBuilder setName(String name) {
		this.name = name;
		return this;}
	
	public CustomerBuilder setAddress(String address) {
		this.address = address;
		return this;}
	
	public CustomerBuilder setPhone(String phone) {
		this.phone = phone;
		return this;}
	
	public CustomerBuilder setEmail(String email) {
		this.email = email;
		return this;}
	
	public Customer build() {
		return new Customer(id, name, address, phone, email);}
}