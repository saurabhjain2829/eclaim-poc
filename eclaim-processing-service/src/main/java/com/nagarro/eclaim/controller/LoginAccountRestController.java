package com.nagarro.eclaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.eclaim.constants.Constants;
import com.nagarro.eclaim.dto.CustomerCreateAccountRequest;
import com.nagarro.eclaim.dto.UserMessage;
import com.nagarro.eclaim.service.LoginAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Login Account Apis", description = "Apis related to Login accounts")
public class LoginAccountRestController {

	@Autowired
	private LoginAccountService loginAccountService;

	@ApiOperation(value = "Create a customer account", response = UserMessage.class)
	@PostMapping(path = "/customers/create-account", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserMessage> createCustomerAccount(@RequestBody CustomerCreateAccountRequest request)
			throws Exception {

		loginAccountService.createCustomerAccount(request);
		return ResponseEntity.ok()
				.body(new UserMessage(Constants.SUCCESS_CODE, Constants.ACCOUNT_CREATED_SUCESSFULLY));
	}

}
