package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Register;
import com.web.model.Register1;
import com.web.model.SuperAdminLogin;
import com.web.repo.Register1Repo;
import com.web.repo.RegisterRepo;
import com.web.repo.SuperAdminRepo;
import com.web.service.SuperAdminView;

@RestController
public class SuperAdminViewController {
	@Autowired
	SuperAdminView SiperService;
	@Autowired
	SuperAdminRepo adminrepo;
	@Autowired
	RegisterRepo repo;
	@Autowired
	Register1Repo repo1;

	@GetMapping("/alluserregisters")
	public List<Register> getAlluserRegister() {
		return SiperService.viewAllRegister();
	}

	@GetMapping("/alladminregisters")
	public List<Register1> getAlladminRegister() {
		return SiperService.viewAllAdminRegister();
	}

	@PostMapping("/superadminlogin")
	public String superAdminSign(@RequestBody SuperAdminLogin login) {

		String sendemail = login.getEmail();
		String sendpassword = login.getPassword();
		SuperAdminLogin login1 = adminrepo.findByEmailAndPassword(sendemail, sendpassword);
		if (login1 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@DeleteMapping("/deleteuserreg")
	public String supadminDeleteUserReg(@RequestParam String email) {
		Register login = repo.findByEmail(email);
		if (login != null) {
			repo.deleteById(email);
			return "deleteSuccess";

		} else {
			return "deletefail";
		}
	}

	@DeleteMapping("/deleteadminreg")
	public String supadminDeleteAdminReg(@RequestParam String email) {
		Register1 login = repo1.findByEmail(email);
		if (login != null) {
			repo1.deleteById(email);
			return "deleteSuccess";

		} else {
			return "deletefail";
		}
	}
}
