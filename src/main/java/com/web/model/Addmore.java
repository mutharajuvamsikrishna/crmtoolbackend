package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addmore {
	@Id
	private String email;
	private String empid;
	private String gender;
	private String region;
	private String country;
	private String city;

	public Addmore() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Addmore [email=" + email + ", empid=" + empid + ", gender=" + gender + ", region=" + region
				+ ", country=" + country + ", city=" + city + ", getEmail()=" + getEmail() + ", getEmpid()="
				+ getEmpid() + ", getGender()=" + getGender() + ", getRegion()=" + getRegion() + ", getCountry()="
				+ getCountry() + ", getCity()=" + getCity() + "]";
	}

}
