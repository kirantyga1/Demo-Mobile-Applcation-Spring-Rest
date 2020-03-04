package com.mobileapp.ws.demo.mobile.app.ws.controller;

import java.rmi.server.UID;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.ws.demo.mobile.app.ws.exceptions.UserServiceException;
import com.mobileapp.ws.demo.mobile.app.ws.model.UpdateUserDetails;
import com.mobileapp.ws.demo.mobile.app.ws.model.request.UserDetailsRequestModel;
import com.mobileapp.ws.demo.mobile.app.ws.service.UserService;
import com.mobileapp.ws.demo.mobile.app.ws.service.impl.UserServiceImpl;
import com.mobileapp.ws.demo.mobile.app.ws.ui.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	Map<String, User> users;

	@SuppressWarnings("unused")
	@GetMapping(path = "/{userId}", produces = {

			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUsers(@PathVariable String userId) {
		if (true)
			throw new UserServiceException("userServiceException thrown");

		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		
		User user = new UserServiceImpl().getUsers();
		return "getUsers was called with page = " + page + " and limit =" + limit + "and sort=" + sort;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				 produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<User> createUsers(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		User user = new UserServiceImpl().createUsers(userDetails);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public User updateUsers(@PathVariable String userId, @Valid @RequestBody UpdateUserDetails updateUserDetails) {
		User storeUserDetails = users.get(userId);
		storeUserDetails.setFirstName(updateUserDetails.getFirstName());
		storeUserDetails.setLastName(updateUserDetails.getLastName());
		users.put(userId, storeUserDetails);

		return storeUserDetails;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity deleteUsers(@PathVariable String userId) {
		User storeUserDetails = users.get(userId);

		users.remove(userId);

		return ResponseEntity.noContent().build();
	}
}
