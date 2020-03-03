package com.mobileapp.ws.demo.mobile.app.ws.controller;

import java.rmi.server.UID;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

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

import com.mobileapp.ws.demo.mobile.app.ws.model.request.UserDetailsRequestModel;
import com.mobileapp.ws.demo.mobile.app.ws.ui.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	Map<String, User> users;
	
	@GetMapping(path = "/{userId}", produces = {

			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUsers(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		/*
		 * if (sort == null) { return "String value is null"; } else { return
		 * "Printed String value"; }
		 */
		return "getUsers was called with page = " + page + " and limit =" + limit + "and sort=" + sort;
	}

	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<User> createUsers(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		User user = new User();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setEmail(userDetails.getPassword());
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		if(users == null) users = new HashMap<>();
		users.put(userId, user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping
	public String updateUsers() {
		return "updateUsers called";
	}

	@DeleteMapping
	public String deleteUsers() {
		return "deleteUsers called";
	}
}
