package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.BookDetailEntity;


public interface BookDetailService {
	BookDetailEntity saveBookDetail(BookDetailEntity bookdetail);
	List<BookDetailEntity> getAllBookDetail();
	BookDetailEntity getBookDetailById(long id);
	BookDetailEntity updateBookDetail(BookDetailEntity bookdetail, long id);
	void deleteBookDetail(long id);
}
