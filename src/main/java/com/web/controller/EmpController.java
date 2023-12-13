package com.web.controller;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.MyClass;
import com.web.model.Pro;
import com.web.repo.ProRepo;
import com.web.repo.RegisterRepo;
import com.web.service.EmailService;

@RestController
@CrossOrigin(origins = MyClass.BASE_URL)
public class EmpController {

	@Autowired
	private ProRepo repo1;

	@Autowired
	private RegisterRepo repo5;
	@Autowired
	private EmailService emailservice;

	@PostMapping("/prosave") // save professional details
	public String profesionalsave(@RequestBody Pro emp, Model model) throws MessagingException {

		repo1.save(emp);
		String email = emp.getEmail();

		String bdmname = emp.getBdmname();
		String company = emp.getCmpname();
		String country = emp.getCoun();
		String intserv = emp.getIntrestserv();
		String web = emp.getWebsite();
		Date followup = emp.getFollowup();
		String region = emp.getRegion();
		String custate = emp.getCurrentstate();
		String domain = emp.getDomain();
		String link = emp.getLinkprof();
		String summary = emp.getMoredetail();
		String subject = company + " Client from " + bdmname;
		String body = "Dear " + bdmname + "," + "\n" + "These details for  " + company
				+ "  are saved in Onie Soft CRM System." + "\n" + "**************************\n" + "BDM Name: "
				+ bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: " + followup + "\n"
				+ "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: " + intserv + "\n"
				+ "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web + "\n"
				+ "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
				+ "**************************";

		emailservice.sendEmail(email, subject, body);
		String adminRecipientEmail = "slrvamsikrishna@gmail.com";
		String adminSubject = company + " Client from " + bdmname;
		String adminBody = "Dear Ramana," + "\n" + "These details for  " + company
				+ "  are saved in Onie Soft CRM System." + "\n" + "**************************\n" + "BDM Name: "
				+ bdmname + "\n" + "Current State: " + custate + "\n" + "Follow-Up Date: " + followup + "\n"
				+ "Company Name: " + company + "\n" + "Industry: " + domain + "\n" + "Services: " + intserv + "\n"
				+ "Region: " + region + "\n" + "Country: " + country + "\n" + "Website: " + web + "\n"
				+ "Company LinkedIn Profile: " + link + "\n" + "Summary: " + summary + "\n"
				+ "**************************";
		emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		return "personaldetails";

	}

}
