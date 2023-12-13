package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Addmore;
import com.web.service.AddmoreService;
import com.web.service.ViewAddmoreDetails;

@RestController

public class AddmoreController {

	@Autowired
	AddmoreService service;
	@Autowired
	ViewAddmoreDetails service1;

	@PostMapping("/addmore")
	public String addMoreData(@RequestBody Addmore addcus) {
		// Call the AddmoreService method to process the data
		String result = service.AddmoreInfo(addcus);

		// You can perform additional processing or return a different response if
		// needed.
		return "addmoredone";
	}

	@GetMapping("/viewaddmore")
	public Addmore ViewAddmoreProfile(@RequestParam String email) {
		return service1.getAddmores(email);
	}
}
