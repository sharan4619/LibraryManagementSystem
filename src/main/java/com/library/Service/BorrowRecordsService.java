package com.library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Models.BorrowRecords;
import com.library.Repository.BorrowRecordsRepo;

@Service
public class BorrowRecordsService {

	@Autowired
	BorrowRecordsRepo borrowRecordsRepo;

	public BorrowRecords borrowedRecords(BorrowRecords borrowRecords) {

		borrowRecordsRepo.save(borrowRecords);
		return borrowRecords;
	}

}
