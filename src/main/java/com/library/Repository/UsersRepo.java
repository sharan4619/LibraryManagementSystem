package com.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.library.Models.UsersRequest;

@Repository
public interface UsersRepo extends JpaRepository<UsersRequest, Long> {

	UsersRequest findByName(String username);

}
