package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.filter.JwtAdminRequestFilter;
import com.web.service.UserDetail1;

@EnableWebSecurity
@Configuration
@Order(2)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired

	private UserDetail1 myUserDetailsService1;

	@Autowired
	private JwtAdminRequestFilter jwtAdminRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService1);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean(name = "adminAuthentication")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers("/authenticate", "/authenticate1", "/register", "/save", "/otp1", "/changepassword",
						"/otp5", "/changepassword1", "/adminregister", "/adminotp1", "/adminsave",
						"/adminchangepassword", "/adminotp5", "/adminchangepassword1", "/adminreq")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().cors().and() // Use the
																										// configured
																										// CORS settings
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtAdminRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

}