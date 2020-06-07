package com.nagarro.policy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.policy.model.PolicyEntity;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Long>, JpaSpecificationExecutor<PolicyEntity> {

	@Query("From PolicyEntity where  policyId=:policyId")
	Optional<PolicyEntity> findByPolicyId(@Param("policyId") String policyId);
}
