package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.model.Addmore;
import com.web.repo.AddmoreRepo;

@Service

public class AddmoreService {
	@Autowired
	AddmoreRepo addmorerepo;

	public String AddmoreInfo(@RequestBody Addmore addcus) {
		addmorerepo.save(addcus);
		return "succcess";
	}
}
