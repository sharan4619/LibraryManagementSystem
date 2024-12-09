package com.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Models.Books;
import com.library.Models.BorrowBookRequest;
import com.library.Models.BorrowBookResponse;
import com.library.Models.BorrowRecords;
import com.library.Models.DeleteBooksResponse;
import com.library.Models.UpdateBooksRequest;
import com.library.Models.UsersRequest;
import com.library.Models.UsersResponse;
import com.library.Service.BooksService;
import com.library.Service.BorrowBooksService;
import com.library.Service.BorrowRecordsService;
import com.library.Service.UserSaveService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

	@Autowired
	UserSaveService usersService;

	@Autowired
	BooksService booksService;

	@Autowired
	BorrowRecordsService borrowRecordsService;

	@Autowired
	BorrowBooksService borrowBooksService;

	@PostMapping("/register")
	public UsersResponse createUser(@RequestBody UsersRequest usersRequest) {
		return usersService.registerUser(usersRequest);

	}
	@PostMapping("/login")
	public String login(@RequestBody UsersRequest usersRequest) {
		return usersService.verify(usersRequest);
	}

	@PostMapping("/books-list")
	public Books listOfBooks(@RequestBody Books books) {
		return booksService.addBooks(books);
	}

	@PostMapping("/borrow-records")
	public BorrowRecords borrow(@RequestBody BorrowRecords borrowRecords) {
		return borrowRecordsService.borrowedRecords(borrowRecords);
	}

	@GetMapping("/search-books/{title}")
	public Books searchBooks(@PathVariable String title) {
		return booksService.selectBooks(title);
	}

	@PutMapping("/update-books/{bookId}")
	public Books editDetails(@PathVariable Long bookId, @RequestBody UpdateBooksRequest updateBooks) {
		return booksService.edit(bookId, updateBooks);
	}

	@DeleteMapping("/delete/{bookId}")
	public DeleteBooksResponse deleteBooks(@PathVariable Long bookId) {
		return booksService.deleteBook(bookId);
	}

	@PostMapping("/borrow-book")
	public BorrowBookResponse borrowBook(@RequestBody BorrowBookRequest borrowBookRequest) {
		return borrowBooksService.borrow(borrowBookRequest);
	}
	
	@GetMapping("/sort/{books}")
	public List<Books> sortBasedOnAuthor(@PathVariable String books){
		return booksService.sortBooks(books);
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
