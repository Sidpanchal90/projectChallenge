package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Books;
import com.crud.repository.Repository;

@Service
public class BooksService {
	@Autowired
	Repository booksRepository;

	public List<Books> getAllBooks() {
		/*
		 * List<Books> books = new ArrayList<Books>();
		 * booksRepository.findAll().forEach(books1 -> books.add(books1));
		 */
		List<Books> books = booksRepository.findAll();
		return books;
	}

	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	public String saveOrUpdate(Books books) {
		booksRepository.save(books);
		return "";
	}

	public String delete(int id) {
		booksRepository.deleteById(id);
		return "";
	}

	public String update(Books books, int bookid) {
		booksRepository.save(books);
		return "";
	}
}
