package com.crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Books;
import com.crud.service.BooksService;

@RestController
@RequestMapping("/operation")
public class BooksController {
	@Autowired
	BooksService booksService;

	@GetMapping("/book")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

	@DeleteMapping("/book/{bookid}")
	private String deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
		return "Your record delete successfully";
	}

	@PostMapping("/books")
	private String saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return "Your record added successfully";
	}

	@PutMapping("/books")
	private String update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return "Your record update successfully";
	}
}
