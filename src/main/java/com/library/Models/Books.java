package com.library.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	private String author;
	private String isbn;
	private boolean isAvailability;

	}


