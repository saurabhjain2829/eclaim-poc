package com.nagarro.policy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.policy.dto.PolicyDetails;
import com.nagarro.policy.dto.PolicyRequest;
import com.nagarro.policy.model.PolicyEntity;
import com.nagarro.policy.repository.PolicyRepository;
import com.nagarro.policy.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	PolicyRepository policyRepository;

	@Override
	public PolicyDetails fetchPolicyDetails(String policyId) {
		Optional<PolicyEntity> policyEntity = policyRepository.findByPolicyId(policyId);
		return policyEntity.isPresent() ? policyEntity.get().buildPolicyDTO() : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PolicyDetails> fetchAllPolicies() {
		List<PolicyEntity> list = policyRepository.findAll();
		return list.stream().map(entity -> entity.buildPolicyDTO()).collect(Collectors.toList());
	}

	@Override
	public void createPolicy(PolicyRequest policyRequest) throws Exception {
		Optional<PolicyEntity> dbValue = policyRepository.findByPolicyId(policyRequest.getPolicyId());
		if (dbValue.isPresent()) {
			throw new Exception("Policy Already exists");
		}

		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setActive(Boolean.TRUE);
		policyEntity.setCreatedDate(new Date());
		policyEntity.setCustomerEmail(policyRequest.getCustomerEmail());
		policyEntity.setCustomerName(policyRequest.getCustomerName());
		policyEntity.setUpdatedDate(new Date());
		policyEntity.setPolicyId(policyRequest.getPolicyId());
		policyRepository.save(policyEntity);

	}

}
