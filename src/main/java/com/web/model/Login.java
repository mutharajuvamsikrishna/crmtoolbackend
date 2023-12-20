package com.web.model;

public class Login {
	private String id;
	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", password=" + password + ", getId()=" + getId()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String email;
	private String password;
	public Login() {
		
	}
	
	

}
