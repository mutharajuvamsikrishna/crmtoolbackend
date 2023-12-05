package com.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.model.Addmore;
import com.web.model.Pro;
import com.web.repo.AddmoreRepo;
import com.web.repo.ProRepo;

@Service
public class ViewAddmoreDetails {
	@Autowired
	AddmoreRepo addmorerepo;
	@Autowired
	ProRepo repo1;

	public Addmore getAddmores(@RequestParam String email) {
		Addmore add = addmorerepo.findByEmail(email);
		return add;
	}

	public String updateUserEdit(@RequestBody Pro pro) {
		Long id = pro.getId();
		Optional<Pro> pro1 = repo1.findById(id);
		if (pro1 != null) {
			repo1.save(pro);
		}
		return "updated successfullly";
	}
}
