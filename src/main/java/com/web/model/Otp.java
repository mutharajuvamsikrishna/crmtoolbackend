package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Otp {

    @Id
    private String id;
    private String otpValue;

    // Add a default constructor
    public Otp() {
        // Empty constructor required by Hibernate
    }

    public Otp(String id, String otpValue) {
        this.id = id;
        this.otpValue = otpValue;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(String otpValue) {
		this.otpValue = otpValue;
	}

	@Override
	public String toString() {
		return "Otp [id=" + id + ", otpValue=" + otpValue + "]";
	}

    // ... Getters and setters, and other methods ...

}

