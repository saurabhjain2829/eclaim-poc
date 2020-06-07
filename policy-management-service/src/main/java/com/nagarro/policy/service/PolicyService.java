package com.nagarro.policy.service;

import java.util.List;

import com.nagarro.policy.dto.PolicyDetails;
import com.nagarro.policy.dto.PolicyRequest;

public interface PolicyService {
	PolicyDetails fetchPolicyDetails(String policyId);

	List<PolicyDetails> fetchAllPolicies();

	void createPolicy( PolicyRequest policyRequest) throws Exception;

}
