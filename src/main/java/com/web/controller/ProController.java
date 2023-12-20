package com.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Pro;
import com.web.repo.ProRepo;
import com.web.service.EmailService;
import com.web.service.ViewAddmoreDetails;

@RestController

public class ProController {

	@Autowired
	private ProRepo proRepo;
	@Autowired
	private ProRepo repo1;
	@Autowired
	ViewAddmoreDetails service;
	@Autowired
	private EmailService emailservice;

	@GetMapping("/req")
	public List<Pro> getPros() {
		return repo1.findAll();
	}

	@GetMapping("/search")

	public List<Pro> searchPro(@RequestParam("query") String query, Model model) {
		List<Pro> users1 = proRepo.searchPro(query);
		model.addAttribute("users1", users1);
		return users1;
	}

	@DeleteMapping(value = "/delete") // edited /per455
	public String delete(@RequestParam Long id) throws MessagingException {
		Optional<Pro> proOptional = repo1.findById(id);

		if (proOptional.isPresent()) {
			Pro pro = proOptional.get();

			String email = pro.getEmail();
			String bdmname = pro.getBdmname();
			String company = pro.getCmpname();
			String country = pro.getCoun();
			String intserv = pro.getIntrestserv();
			String web = pro.getWebsite();
			Date followup = pro.getFollowup();
			String region = pro.getRegion();
			String custate = pro.getCurrentstate();
			String domain = pro.getDomain();
			String link = pro.getLinkprof();
			String summary = pro.getMoredetail();

			String subject = company + " CRM Details Deleted By " + bdmname;
			String body = "Dear " + bdmname + "," + "\n" + "These details for  " + company
					+ "  are Deleted in Onie Soft CRM System." + "\n" + "**************************\n" + "ID:  " + id
					+ "\n" + "BDM Name: " + bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: "
					+ followup + "\n" + "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: "
					+ intserv + "\n" + "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web
					+ "\n" + "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
					+ "**************************";
			emailservice.sendEmail(email, subject, body);
			String adminRecipientEmail = "slrvamsikrishna@gmail.com";
			String adminSubject = company + " CRM Details Deleted By " + bdmname;
			String adminBody = "Dear Ramana," + "\n" + "These details for  " + company + "  are Deleted"
					+ " in Onie Soft CRM System." + "\n" + "**************************\n" + "ID:  " + id + "\n"
					+ "BDM Name: " + bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: " + followup
					+ "\n" + "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: " + intserv
					+ "\n" + "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web + "\n"
					+ "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
					+ "**************************";
			emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
			repo1.deleteById(id);
		}
		return "Deleted Sucess Fully";

	}

	@PutMapping("/usereditupdate")
	public String updateUserEdit1(@RequestBody Pro pro) throws MessagingException {
		String email = pro.getEmail();

		String bdmname = pro.getBdmname();
		String company = pro.getCmpname();
		String country = pro.getCoun();
		String intserv = pro.getIntrestserv();
		String web = pro.getWebsite();
		Date followup = pro.getFollowup();
		String region = pro.getRegion();
		String custate = pro.getCurrentstate();
		String domain = pro.getDomain();
		String link = pro.getLinkprof();
		String summary = pro.getMoredetail();
		Long id = pro.getId();
		String subject = company + " CRM Details Updated By " + bdmname;
		String body = "Dear " + bdmname + "," + "\n" + "These details for  " + company
				+ "  are Update and saved in Onie Soft CRM System." + "\n" + "**************************\n" + "ID:  "
				+ id + "\n" + "BDM Name: " + bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: "
				+ followup + "\n" + "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: "
				+ intserv + "\n" + "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web + "\n"
				+ "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
				+ "**************************";
		emailservice.sendEmail(email, subject, body);
		String adminRecipientEmail = "slrvamsikrishna@gmail.com";
		String adminSubject = company + " CRM Details Updated By " + bdmname;
		String adminBody = "Dear Ramana," + "\n" + "These details for  " + company
				+ "  are Update and saved in Onie Soft CRM System." + "\n" + "**************************\n" + "ID:  "
				+ id + "\n" + "BDM Name: " + bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: "
				+ followup + "\n" + "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: "
				+ intserv + "\n" + "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web + "\n"
				+ "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
				+ "**************************";
		emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		return service.updateUserEdit(pro);
	}

}
