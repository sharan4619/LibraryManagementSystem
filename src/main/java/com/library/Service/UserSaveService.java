package com.library.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.Models.UsersRequest;
import com.library.Models.UsersResponse;
import com.library.Repository.UsersRepo;

@Service
public class UserSaveService {

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	JWTService jwtService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public UsersResponse registerUser(UsersRequest usersRequest) {
		UsersResponse usersResponse = new UsersResponse();
		usersRequest.setPassword(encoder.encode(usersRequest.getPassword()));
		usersRepo.save(usersRequest);

		String status = "registered successfully";
		usersResponse.setStatus(status);

		return usersResponse;
	}

	public String verify(UsersRequest usersRequest) {
		Authentication authentication = manager.authenticate(
				new UsernamePasswordAuthenticationToken(usersRequest.getName(), usersRequest.getPassword()));

		if (authentication.isAuthenticated())
			return jwtService.generateToken(usersRequest.getName());

		return "failed";

	}

}
