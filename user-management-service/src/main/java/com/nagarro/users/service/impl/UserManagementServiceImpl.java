package com.nagarro.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.users.dto.UserDetails;
import com.nagarro.users.service.IdentityManagamentService;
import com.nagarro.users.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Autowired
	IdentityManagamentService identityManagamentService;

	@Override
	public UserDetails fetchUserDetails(String emailAddress) throws Exception {
		UserDetails userDetails=identityManagamentService.fetchUserAccount(emailAddress);
		if(userDetails==null){
			throw new Exception("No user found for email- "+emailAddress);
		}
		return userDetails;
	}

	@Override
	public void createUserDetails(UserDetails userDetails) throws Exception {
		identityManagamentService.createUserAccount(userDetails);
	}

	@Override
	public boolean verifyUser(String userName, String password) {
		return identityManagamentService.verifyUser(userName, password);
	}

}
