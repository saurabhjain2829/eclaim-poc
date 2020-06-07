package com.nagarro.users.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.users.dto.UserDetails;
import com.nagarro.users.model.UserEntity;
import com.nagarro.users.repository.UserRepository;
import com.nagarro.users.service.IdentityManagamentService;

@Service
public class IdentityManagamentServiceImpl implements IdentityManagamentService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails fetchUserAccount(String userEmail) {
		/**
		 * fetch details from Active Directory based on email address and
		 * populate User Details
		 **/

		/**
		 * TODO remove- for POC we are using database
		 */

		Optional<UserEntity> entity = userRepository.findByEmail(userEmail);
		return entity.isPresent() ? entity.get().buildUserDetailsDTO() : null;

	}

	@Override
	public boolean createUserAccount(UserDetails userDetails) throws Exception {
		/**
		 * create details in Active Directory based on email address, roles, and
		 * password and populate User Details
		 **/

		/**
		 * TODO remove- for POC we are using database
		 */
		Optional<UserEntity> entity = userRepository.findByEmail(userDetails.getEmail());
		if (entity.isPresent()) {
			throw new Exception("User Already exists for - " + userDetails.getEmail());
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setCreatedDate(new Date());
		userEntity.setUserType(userDetails.getUserType());
		userEntity.setUserStatus(userDetails.getStatus());
		userEntity.setPassword(userDetails.getPassword());
		userEntity.setName(userDetails.getName());
		userEntity.setEmail(userDetails.getEmail());
		userEntity.setUpdatedDate(new Date());
		userRepository.save(userEntity);
		return true;
	}

	@Override
	public boolean verifyUser(String userEmail, String password) {
		// verify account with email and password in active directory

		/**
		 * TODO remove- for POC we are using database
		 */
		Optional<UserEntity> entity = userRepository.findByEmail(userEmail);
		return entity.isPresent() ? entity.get().getPassword().equals(password) : Boolean.FALSE;
	}

}
