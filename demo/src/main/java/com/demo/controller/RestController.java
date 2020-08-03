package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.demo.helper.UserHelper;
import com.demo.request.FindUserRequest;
import com.demo.request.User;
import com.demo.response.UserResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private static final Logger log = LoggerFactory.getLogger(RestController.class);

	@CrossOrigin
	@PostMapping("/users")
	private UserResponse newUser(final @RequestBody User user) {

		log.debug("user: " + user);

		// input validations
		if (user == null) {
			log.error("empty user: " + user);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
		}

		// TODO input validations etc
		if (StringUtils.isEmpty(user.getIC())) {
			log.error("empty user.getIC(): " + user.getIC());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IC is required");
		}
		
		if (StringUtils.isEmpty(user.getIC())) {
			log.error("empty user.getIC(): " + user.getIC());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IC is required");
		}
		
		if (StringUtils.isEmpty(user.getName())) {
			log.error("empty user.getName(): " + user.getName());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
		}
		
		if (StringUtils.isEmpty(user.getPhoneNumber())) {
			log.error("empty user.getPhoneNumber(): " + user.getPhoneNumber());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone Number is required");
		}
		
		if (StringUtils.isEmpty(user.getGender())) {
			log.error("empty user.getGender(): " + user.getGender());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gender is required");
		}
		
		UserHelper.writeToCSV(user);

		UserResponse response = new UserResponse();

		response.setGender(user.getGender());
		response.setIC(user.getIC());
		response.setName(user.getName());
		response.setPhoneNumber(user.getPhoneNumber());

		return response;
	}

	@CrossOrigin
	@PostMapping("/users/find")
	private UserResponse findUser(final @RequestBody FindUserRequest criteria) {

		log.debug("search criteria: " + criteria);

		// input validations
		if (criteria == null) {
			log.error("empty criteria: " + criteria);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
		}

		// TODO input validations etc
		if (criteria.getType() == null) {
			log.error("empty criteria.getType(): " + criteria.getType());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Criteria Type is required");
		}
		
		if (StringUtils.isEmpty(criteria.getValue())) {
			log.error("empty criteria.getValue(): " + criteria.getValue());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Search value is required");
		}

		try {
			UserHelper.findInCSV(criteria);
		} catch (Exception e) {
			// TODO error handling
			e.printStackTrace();
			log.error("exception: " + e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
		}

		UserResponse response = new UserResponse();

		return response;
	}
}