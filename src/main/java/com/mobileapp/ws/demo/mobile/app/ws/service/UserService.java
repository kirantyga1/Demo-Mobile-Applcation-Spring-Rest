package com.mobileapp.ws.demo.mobile.app.ws.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.mobileapp.ws.demo.mobile.app.ws.model.request.UserDetailsRequestModel;
import com.mobileapp.ws.demo.mobile.app.ws.ui.model.User;

public interface UserService {

	public User createUsers(@RequestBody UserDetailsRequestModel userDetails);
}
