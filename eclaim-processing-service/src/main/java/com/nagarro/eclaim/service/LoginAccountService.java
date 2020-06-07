package com.nagarro.eclaim.service;

import com.nagarro.eclaim.dto.CustomerCreateAccountRequest;
import com.nagarro.eclaim.exceptions.EclaimException;

public interface LoginAccountService {

	void createCustomerAccount(CustomerCreateAccountRequest request) throws Exception;

}
