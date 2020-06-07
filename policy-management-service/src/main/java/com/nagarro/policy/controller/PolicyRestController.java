package com.nagarro.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.policy.dto.PolicyDetails;
import com.nagarro.policy.dto.PolicyRequest;
import com.nagarro.policy.service.PolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/policies/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Policy Management Service")
public class PolicyRestController {

	@Autowired
	private PolicyService policyService;

	@ApiOperation(value = "Fetch Policy Details by policyId", response = PolicyDetails.class)
	@GetMapping(path = "{policyId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PolicyDetails> fetchPolicyDetails(@PathVariable(value = "policyId") String policyId) {

		return ResponseEntity.ok().body(policyService.fetchPolicyDetails(policyId));
	}

	@ApiOperation(value = "Fetch ALL Policy Details", response = PolicyDetails.class)
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PolicyDetails>> fetchAllPolicies() {

		return ResponseEntity.ok().body(policyService.fetchAllPolicies());
	}

	@ApiOperation(value = "Create Details", response = PolicyDetails.class)
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createAllPolicies(@RequestBody PolicyRequest policyRequest) throws Exception {
		policyService.createPolicy(policyRequest);

		return ResponseEntity.ok().body("Policy Created Successfilly");
	}

}
