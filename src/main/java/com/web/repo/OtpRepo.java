package com.web.repo;

import org.springframework.data.repository.CrudRepository;

import com.web.model.Otp;

public interface OtpRepo extends CrudRepository<Otp,String> {

	Otp findByOtpValue(String otp);




}
