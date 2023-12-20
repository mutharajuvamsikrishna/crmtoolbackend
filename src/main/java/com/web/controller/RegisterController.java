package com.web.controller;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.AuthenticationResponse;
import com.web.model.Otp;
import com.web.model.Pro;
import com.web.model.Register;
import com.web.model.Register1;
import com.web.repo.OtpRepo;
import com.web.repo.ProRepo;
import com.web.repo.Register1Repo;
import com.web.repo.RegisterRepo;
import com.web.service.EmailService;
import com.web.service.UserDetail;
import com.web.service.UserDetail1;
import com.web.util.JwtUtil;

@RestController

public class RegisterController {

	@Autowired
	private RegisterRepo repo7;

	@Autowired
	private Register1Repo repo8;

	@Autowired
	private ProRepo repo1;

	@Autowired
	private OtpRepo otprepo;
	@Autowired
	private RegisterRepo regrepo;
	@Autowired
	private EmailService emailservice;

	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	UserDetail userDetailsService;
	@Autowired
	UserDetail1 userDetailsService1;
	@Autowired

	@Qualifier("userAuthentication")
	private AuthenticationManager userAuthentication;

	@Autowired
	@Qualifier("adminAuthentication")
	private AuthenticationManager adminAuthentication;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Register authenticationRequest) throws Exception {

		try {
			userAuthentication.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
					authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@RequestMapping(value = "/authenticate1", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken1(@RequestBody Register1 authenticationRequest) throws Exception {

		try {
			// Use the AuthenticationManager from AdminSecurityConfig
			Authentication authentication = adminAuthentication.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService1.loadUserByUsername(authenticationRequest.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@GetMapping("/helloworld")
	public String Helloworld() {
		return "Hello World";
	}

	@PostMapping("/register")
	public String addForm11(@RequestBody

	Register customer, ModelMap model, HttpSession session) {
		String email = customer.getEmail();
		;
		String ename = customer.getEname();
		String mob = customer.getMob();
		String password = customer.getPassword();
		String cnpassword = customer.getCnpassword();
		model.put("ename", ename);

		Register reg = repo7.findByEmail(email);
		Register reg1 = repo7.findByMob(mob);
		if (reg != null || reg1 != null) {
			return "regfail";
		}

		else {
			Register newRegister = new Register();
			newRegister.setEmail(email);
			newRegister.setEname(ename);
			newRegister.setMob(mob);
			newRegister.setPassword(password);
			newRegister.setCnpassword(cnpassword);

			// Generate OTP
			String otp = generateOTP();
			String otpId = UUID.randomUUID().toString();

			// Save the OTP to the database using the Otp class

			Otp otpEntity = new Otp(otpId, otp);
			otprepo.save(otpEntity);
			String adminemail = "slrvamsikrishna@gmail.com";
			try {
				// Send OTP via email
				sendEmail(adminemail, "OTP Verification",
						"Hello " + ename + ",\n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
				System.out.println("Email sent successfully.");
			} catch (MessagingException e) {
				// Handle any exceptions that occurred during email sending
				e.printStackTrace();
				return "otperror";
			}

			return "otp1";
		}
	}

	// otp for applicant

	@PostMapping("/otp1")
	public String submitOTP1(@RequestParam String otp, ModelMap model) {

		if (otp == null) {
			System.out.println("otp is null1");
		} else {
			System.out.println("otp is Entered" + otp);
		}

		Otp otp2 = otprepo.findByOtpValue(otp);
		if (otp2 == null) {
			return "inotp";
		}
		String otp3 = otp2.getOtpValue();
		if (otp != null) {
			System.out.println("Stored otp is not null" + otp3);
		}

		// Check if newRegister object is found in the session and OTP is correct
		if (otp != null && otp.equals(otp3)) {
			// Save the newRegister object using the repository

			otprepo.delete(otp2);
			return "regsucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "inotp";
		}
	}

	@PostMapping("/save")
	public String addEmp(@RequestBody Register emp, ModelMap m) throws MessagingException {
		repo7.save(emp);// Sending Email
		String mob = emp.getMob();
		String email = emp.getEmail();
		String recipientEmail = emp.getEmail();
		String password = emp.getPassword();
		String ename = emp.getEname();
		String subject = "Onie Soft CRM: " + ename + " Registration is Successful !";
		String body = "Dear " + ename + ",\n" + "Your Registration is Successful with Onie Soft CRM System.\n"
				+ "The details are …\n" + "**************************\n" + "Name: " + ename + "\n" + "Mobile Number: "
				+ mob + "\n" + "Email ID: " + email + "\n" + "Password: " + password + "\n"
				+ "**************************\n"
				+ "Please http://localhost:5173/login Onie Soft CRM System to check and further usage.\n"
				+ "With Best Wishes,\n" + "Onie Soft CRM Support.\n" + "{support@oniesoft.com}";
		emailservice.sendEmail(recipientEmail, subject, body);
		String adminRecipientEmail = "slrvamsikrishna@gmail.com";
		String adminSubject = ename + " Registered with Onie Soft CRM";
		String adminBody = "**************************\n" + "Name: " + ename + "\n" + "Mobile Number: " + mob + "\n"
				+ "Email ID: " + email + "\n" + "Password: " + password + "\n" + "**************************\n"
				+ "Please check and confirm for further access.\n" + "With Best Wishes,\n" + "Onie Soft CRM Support.\n";
		emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		return "Details Saved SucessFully";
	}

//admin Start123

	@PostMapping("/adminregister")
	public String adminregister(@RequestBody

	Register1 customer, ModelMap model) {
		String id = customer.getId();
		String email = customer.getEmail();
		String ename = customer.getEname();
		String mob = customer.getMob();
		String password = customer.getPassword();
		String cnpassword = customer.getCnpassword();
		model.put("ename", ename);

		Register1 reg = repo8.findByEmail(email);
		Register1 reg1 = repo8.findByMob(mob);
		if (reg != null || reg1 != null) {
			return "regfail";

		} else {
			Register1 newRegister = new Register1();
			newRegister.setId(id);
			newRegister.setEmail(email);
			newRegister.setEname(ename);
			newRegister.setMob(mob);
			newRegister.setPassword(password);
			newRegister.setCnpassword(cnpassword);

			// Generate OTP
			String otp = generateOTP();
			String otpId = UUID.randomUUID().toString();

			// Save the OTP to the database using the Otp class

			Otp otpEntity = new Otp(otpId, otp);
			otprepo.save(otpEntity);
			String adminemail = "slrvamsikrishna@gmail.com";
			try {
				// Send OTP via email
				sendEmail(adminemail, "OTP Verification",
						"Hello " + ename + ",\n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
				System.out.println("Email sent successfully.");
			} catch (MessagingException e) {
				// Handle any exceptions that occurred during email sending
				e.printStackTrace();
				return "otperror";
			}

			return "adminotp1";
		}
	}

	// otp for applicant

	// ...

	@PostMapping("/adminotp1")
	public String adminsubmitOTP(@RequestParam String otp, ModelMap model) {

		if (otp == null) {
			System.out.println("otp is null1");
		} else {
			System.out.println("otp is Entered" + otp);
		}

		Otp otp2 = otprepo.findByOtpValue(otp);
		if (otp2 == null) {
			return "inotp";
		}
		String otp3 = otp2.getOtpValue();
		if (otp != null) {
			System.out.println("Stored otp is not null" + otp3);
		}

		// Check if newRegister object is found in the session and OTP is correct
		if (otp != null && otp.equals(otp3)) {
			// Save the newRegister object using the repository

			otprepo.delete(otp2);
			return "adminregsucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "inotp";
		}
	}

	@PostMapping("/adminsave")
	public String aminsave(@RequestBody Register1 emp, ModelMap m) throws MessagingException {
		repo8.save(emp);
		String id = emp.getId();
		String mob = emp.getMob();
		String email = emp.getEmail();
		String recipientEmail = emp.getEmail();
		String password = emp.getPassword();
		String ename = emp.getEname();
		String subject = "Onie Soft CRM: " + ename + " Admin Registration is Successful !";
		String body = "Dear " + ename + ",\n" + "Your Admin Registration is Successful with Onie Soft CRM System.\n"
				+ "The details are …\n" + "**************************\n" + "ID: " + id + "\n" + "Name: " + ename + "\n"
				+ "Mobile Number: " + mob + "\n" + "Email ID: " + email + "\n" + "Password: " + password + "\n"
				+ "**************************\n"
				+ "Please http://localhost:5173/login Onie Soft CRM System to check and further usage.\n"
				+ "With Best Wishes,\n" + "Onie Soft CRM Support.\n" + "{support@oniesoft.com}";
		emailservice.sendEmail(recipientEmail, subject, body);
		String adminRecipientEmail = "slrvamsikrishna@gmail.com";
		String adminSubject = ename + " Admin Registered with Onie Soft CRM";
		String adminBody = "**************************\n" + "ID: " + id + "\n" + "Name: " + ename + "\n"
				+ "Mobile Number: " + mob + "\n" + "Email ID: " + email + "\n" + "Password: " + password + "\n"
				+ "**************************\n" + "Please check and confirm for further access.\n"
				+ "With Best Wishes,\n" + "Onie Soft CRM Support.\n";
		emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		return "adminsaved";
	}

	// admin end123

	// start admin access

	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	public String addForm10(@RequestParam String id, @RequestParam String ename, @RequestParam String email,
			@RequestParam String mob, @RequestParam String password, @RequestParam String cnpassword,
			Register1 customer, ModelMap model, HttpSession session) {

		model.put("ename", ename);

		Register1 reg = repo8.findByEmailAndMob(email, mob);

		if (reg != null) {
			return "regfail";
		} else {
			Register1 newRegister = new Register1();
			newRegister.setId(id);
			newRegister.setEname(ename);
			newRegister.setEmail(email);
			newRegister.setMob(mob);
			newRegister.setPassword(password);
			newRegister.setCnpassword(cnpassword);

			// Generate OTP
			String otp = generateOTP();

			// Store the OTP and its expiration time in session
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime expirationTime = now.plusMinutes(5); // OTP expires in 1 minute
			session.setAttribute("otp1", otp);
			session.setAttribute("otpExpiration", expirationTime);

			session.setAttribute("register10", newRegister);

			try {
				// Send OTP via email
				sendEmail(email, "OTP Verification", "Hello" + " " + ename + ",\n\nYour OTP is: " + " " + otp + " "
						+ "and Your Otp is  Valid 5 Minutes");
			} catch (MessagingException e) {
				// Handle any exceptions that occurred during email sending
				e.printStackTrace();
				return "otperror";
			}

			return "enterotp";
		}
	}

	private String generateOTP() {
		// Generate a random 6-digit OTP
		int otp = (int) (Math.random() * 900000) + 100000;
		return String.valueOf(otp);
	}

	private void sendEmail(String recipientEmail, String subject, String body) throws MessagingException {
		// Replace with your email and password
		String senderEmail = "slrvamsikrishna@gmail.com";
		String senderPassword = "zugweogflidhqcyi";

		// Set properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create session
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		// Create message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
		message.setSubject(subject);
		message.setText(body);

		// Send message
		Transport.send(message);
		System.out.println("Email sent successfully.");
	}

	//

	// otp validatio
	@PostMapping(value = "/otp")
	public String submitOTP(@RequestParam String otp, HttpSession session, ModelMap model) {
		// Get the stored newRegister object from the session
		Register1 newRegister = (Register1) session.getAttribute("register10");
		String reg = (String) session.getAttribute("otp1");

		// Check if newRegister object is found in the session
		if (newRegister != null && reg != null && otp.equals(reg)) {
			// Save the newRegister object using the repository
			Register1 reg2 = repo8.save(newRegister);
			model.put("ename", reg2.getEname());

			// Clear the session after successful registration
			// session.removeAttribute("register1");

			return "reg1sucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "inotp";
		}
	}

//h2

	@GetMapping("/viewprofessional")
	public Pro addForm17(@RequestParam Long id) {
		Pro emp1 = repo1.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Professional with ID " + id + " not found"));

		return emp1;
	}

	@GetMapping("/reg")
	public Register registerdetails(@RequestParam String email) {

		Register emp1 = regrepo.findByEmail(email);

		return emp1;

	}

	@GetMapping("/adminreg")
	public Register1 adminregisterdetails(@RequestParam String email) {

		Register1 emp1 = repo8.findByEmail(email);

		return emp1;

	}
}
