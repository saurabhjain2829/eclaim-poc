package com.nagarro.eclaim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.eclaim.constants.Constants;
import com.nagarro.eclaim.dto.CustomerCreateAccountRequest;
import com.nagarro.eclaim.exceptions.EclaimException;
import com.nagarro.eclaim.service.LoginAccountService;
import com.nagarro.policy.dto.PolicyDetails;
import com.nagarro.policy.service.PolicyService;
import com.nagarro.users.dto.UserDetails;
import com.nagarro.users.dto.UserStatus;
import com.nagarro.users.dto.UserType;
import com.nagarro.users.service.UserManagementService;

@Service
public class LoginAccountServiceImpl implements LoginAccountService {

	@Autowired
	PolicyService policyService;

	@Autowired
	UserManagementService userManagementService;

	@Override
	public void createCustomerAccount(CustomerCreateAccountRequest request) throws Exception {
		PolicyDetails policyDetails = policyService.fetchPolicyDetails(request.getPolicyNo());
		if (policyDetails == null) {
			throw new EclaimException(Constants.POLICY_NOT_FOUND);
		}
		if (!validatePolicyDetails(request, policyDetails)) {
			throw new EclaimException(Constants.INVALID_POLICY_DETAILS);
		}
		userManagementService.createUserDetails(createUserDetails(request));

	}

	private UserDetails createUserDetails(CustomerCreateAccountRequest request) {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(request.getCustomerEmail());
		userDetails.setUserType(UserType.CUSTOMER);
		userDetails.setName(request.getCustomerName());
		userDetails.setStatus(UserStatus.ACTIVE);
		return userDetails;
	}

	private boolean validatePolicyDetails(CustomerCreateAccountRequest request, PolicyDetails policyDetails) {
		return (request.getCustomerName().equalsIgnoreCase(policyDetails.getCustomerName())
				&& request.getCustomerEmail().equalsIgnoreCase(policyDetails.getCustomerEmail()));

	}

}
