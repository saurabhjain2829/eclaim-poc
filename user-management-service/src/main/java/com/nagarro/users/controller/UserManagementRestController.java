package com.nagarro.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.users.dto.UserDetails;
import com.nagarro.users.service.UserManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User Management Service")
public class UserManagementRestController {

	@Autowired
	private UserManagementService userManagementService;

	@ApiOperation(value = "Fetch Policy Details by policyId", response = UserDetails.class)
	@GetMapping(path = "/{useremail}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UserDetails> fetchUserDetails(@PathVariable(value = "useremail") String useremail) throws Exception {

		return ResponseEntity.ok().body(userManagementService.fetchUserDetails(useremail));
	}

}
