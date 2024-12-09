package com.library.Models;

import lombok.Data;

@Data
public class BorrowBookRequest {

	private Long userId;
	private String name;
	private String title;
	private String bookId;
	private String returnDate;

}
