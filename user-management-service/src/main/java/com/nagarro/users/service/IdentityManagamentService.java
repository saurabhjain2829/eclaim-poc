package com.nagarro.users.service;

import com.nagarro.users.dto.UserDetails;

public interface IdentityManagamentService {
	
	UserDetails fetchUserAccount(String userEmail);
	
	boolean createUserAccount(UserDetails userDetails) throws Exception;
	
	boolean verifyUser(String userName,String password);

}
