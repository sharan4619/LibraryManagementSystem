package com.library.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="borrowRecords")
public class BorrowRecords {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recordId;
	
	private Long userId;
	private Long bookId;
	private String borrowDate;
	private String returnDate;

}
