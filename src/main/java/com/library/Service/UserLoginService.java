package com.library.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.Models.UserPrincipal;
import com.library.Models.UsersRequest;
import com.library.Models.UsersResponse;
import com.library.Repository.UsersRepo;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsersRequest users = usersRepo.findByName(username);

		if (users == null) {
			throw new UsernameNotFoundException("user not found");
		}

		return new UserPrincipal(users);
	}

}
