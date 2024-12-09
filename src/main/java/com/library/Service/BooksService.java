package com.library.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.library.Models.Books;
import com.library.Models.DeleteBooksResponse;
import com.library.Models.UpdateBooksRequest;
import com.library.Repository.BooksRepo;

@Service
public class BooksService {

	@Autowired
	BooksRepo booksRepo;

	public Books addBooks(Books books) {

		booksRepo.save(books);

		return books;
	}

	public Books selectBooks(String title) {
		Books books = new Books();
		return booksRepo.findByTitle(title).orElse(books);

	}

	public Books edit(Long bookId, UpdateBooksRequest updateBooks) {
		Books books = new Books();
		Optional<Books> book = booksRepo.findById(updateBooks.getBookId());

		Books existingDetail = book.orElse(books);
		existingDetail.setAvailability(updateBooks.isAvailability());

		booksRepo.save(updateBooks);

		books.setAvailability(updateBooks.isAvailability());

		return books;
	}

	public DeleteBooksResponse deleteBook(Long bookId) {
		DeleteBooksResponse deleteBooks = new DeleteBooksResponse();

		booksRepo.deleteById(bookId);

		String status = "Book Deleted Successfully";
		deleteBooks.setStatus(status);

		return deleteBooks;
	}

	public List<Books> sortBooks(String books) {

		return booksRepo.findAll(Sort.by(Sort.Direction.ASC, books));

	}

}
