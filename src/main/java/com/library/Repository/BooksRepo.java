package com.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.Models.Books;
import com.library.Models.UpdateBooksRequest;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {

	Optional<Books> findByTitle(String title);

	Optional<Books> save(UpdateBooksRequest updateBooks);

}
