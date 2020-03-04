package com.mobileapp.ws.demo.mobile.app.ws.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mobileapp.ws.demo.mobile.app.ws.model.request.UserDetailsRequestModel;
import com.mobileapp.ws.demo.mobile.app.ws.service.UserService;
import com.mobileapp.ws.demo.mobile.app.ws.ui.model.User;

@Service
public class UserServiceImpl implements UserService {

	Map<String, User> users;

	@SuppressWarnings("unchecked")
	@Override
	public User createUsers(UserDetailsRequestModel userDetails) {
		User user = new User();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setEmail(userDetails.getPassword());
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		return user;
	}

	public User getUsers() {
		User user = new User();
		return user;
	}
	
	

}
