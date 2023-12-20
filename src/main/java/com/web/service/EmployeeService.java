package com.web.service;

import java.util.Date; // Import java.util.Date instead of java.sql.Date
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.web.model.Pro;
import com.web.repo.ProRepo;
import com.web.repo.RegisterRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmailService mailSender;
	@Autowired
	private RegisterRepo repo;
	@Autowired
	private ProRepo proRepo; // Add @Autowired for ProRepo

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Scheduled(cron = "0 0 10 * * ?")
	public void sendReminders() throws MessagingException {
		Date currentDate = new Date();
		Date date = new Date();
		// get the list of actions from db which followup date is before the current
		// date
		List<Pro> items = proRepo.findByFollowupOneDayBefore(currentDate);
		List<Pro> persons = proRepo.findByFollowup(date);
		System.out.println(currentDate);
		System.out.println(items.size());
		System.out.println("ok: " + date);
		System.out.println("ok1: " + persons.size());
		for (Pro action : items) {
			sendMail(action);
		}
		for (Pro action : persons) {
			sendMail(action);
		}
	}

	// method to send reminders to users
	public void sendMail(Pro action) throws MessagingException {
		String subject = "Follow-Up Date Reminder";
		String email = action.getEmail();
		String adminemail = "slrvamsikrishna@gmail.com";
		String name = action.getBdmname();
		Date followup = action.getFollowup();
		String date = followup.toLocaleString();
		long id = action.getId();
		String body = "Dear " + name + ",\n" + "Please follow up with this potential client Application Id No " + id
				+ " before this date: " + followup + "\n\n" + "Best Wishes,\n" + "Onie soft CRM Support";

		String adminbody = "Dear Admin,\n" + "Follow-up reminder for client with ID No " + id + ".\n"
				+ "Follow up with " + name + " before this date: " + followup + "\n\n" + "Best Wishes,\n"
				+ "Onie soft CRM Support";
		mailSender.sendEmail(email, subject, body);
		mailSender.sendEmail(adminemail, subject, adminbody);
	}
}
