package com.web.service;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

    public String generateOTP() {
        // Logic to generate a random OTP (e.g., a 6-digit code)
        // Implement your custom OTP generation logic here
        // For simplicity, let's assume the OTP is a 6-digit number
        return String.format("%06d", new Random().nextInt(999999));
    }

    public void sendOTPByEmail(String email, String ename, String otp) throws MessagingException {
        // Logic to send the OTP via email
        // Implement your email sending logic here using JavaMail or any other email library

        // For demonstration purposes, let's print the OTP in the console
        System.out.println("Sending OTP via email to: " + email);
        System.out.println("Hello " + ename + ",\n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
    }
}
