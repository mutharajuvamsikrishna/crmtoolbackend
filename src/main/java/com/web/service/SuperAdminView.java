package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Register;
import com.web.model.Register1;
import com.web.repo.Register1Repo;
import com.web.repo.RegisterRepo;

@Service
public class SuperAdminView {
	@Autowired
	RegisterRepo registerRepo;
	@Autowired
	Register1Repo adminregRepo;

	public List<Register> viewAllRegister() {

		return registerRepo.findAll();
	}

	public List<Register1> viewAllAdminRegister() {

		return adminregRepo.findAll();
	}
}
