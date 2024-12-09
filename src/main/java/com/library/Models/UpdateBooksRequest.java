package com.library.Models;

import lombok.Data;

@Data
public class UpdateBooksRequest {
	
	private Long bookId;
	private boolean isAvailability;

}
