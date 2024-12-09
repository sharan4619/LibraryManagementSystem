package com.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.Models.BorrowRecords;

@Repository
public interface BorrowRecordsRepo extends JpaRepository<BorrowRecords, Long>{

}
