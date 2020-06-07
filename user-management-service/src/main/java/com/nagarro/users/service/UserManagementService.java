package com.nagarro.users.service;

import com.nagarro.users.dto.UserDetails;

public interface UserManagementService {
	UserDetails fetchUserDetails(String emailAddress) throws Exception;

	void createUserDetails(UserDetails userDetails) throws Exception;
	
	boolean verifyUser(String userName,String password);

}
