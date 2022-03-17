package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.BooksEntity;


public interface BooksService {
	BooksEntity saveBook(BooksEntity book);
	List<BooksEntity> getAllBook();
	BooksEntity getBookById(long id);
	BooksEntity updateBook(BooksEntity book, long id);
	void deleteBook(long id);

}
