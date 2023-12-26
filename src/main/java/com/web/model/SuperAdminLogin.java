package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adminlogin")
public class SuperAdminLogin {
	private String email;
	private String password;

	public SuperAdminLogin() {

	}

	@Id
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

	@Override
	public String toString() {
		return "SuperAdminLogin [email=" + email + ", password=" + password + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + "]";
	}

}
