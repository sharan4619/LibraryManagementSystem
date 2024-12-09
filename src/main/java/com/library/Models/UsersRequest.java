package com.library.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="users")
public class UsersRequest {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long userId;
	
	private String name;
	private String email;
	private String password;
	private String role;

}
