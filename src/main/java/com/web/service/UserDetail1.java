package com.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.model.Register1;
import com.web.repo.Register1Repo;

@Service

public class UserDetail1 implements UserDetailsService {

	@Autowired
	private Register1Repo repo1;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Register1 user = repo1.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}

		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}
