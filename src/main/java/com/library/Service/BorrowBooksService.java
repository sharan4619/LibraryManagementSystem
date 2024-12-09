package com.library.Service;

import org.springframework.stereotype.Service;

import com.library.Models.BorrowBookRequest;
import com.library.Models.BorrowBookResponse;

@Service
public class BorrowBooksService {

	public BorrowBookResponse borrow(BorrowBookRequest borrowBookRequest) {
		BorrowBookResponse borrowBookResponse = new BorrowBookResponse();

		String status = "Hooray!! Book Borrowed Successfully";
		borrowBookResponse.setStatus(status);

		return borrowBookResponse;
	}

}
