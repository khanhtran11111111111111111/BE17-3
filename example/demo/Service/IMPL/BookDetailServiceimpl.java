package com.example.demo.Service.IMPL;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.BookDetailEntity;
import com.example.demo.Repository.BookDetailRepository;
import com.example.demo.Service.BookDetailService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class BookDetailServiceimpl implements BookDetailService{
	private BookDetailRepository bookdetailRepository;
	public BookDetailServiceimpl(BookDetailRepository bookdetailRepository) {
		super();
		this.bookdetailRepository=bookdetailRepository;
	}
	@Override
	public BookDetailEntity saveBookDetail(BookDetailEntity bookdetail) {
		return bookdetailRepository.save(bookdetail);
	}

	@Override
	public List<BookDetailEntity> getAllBookDetail() {
		return bookdetailRepository.findAll();
	}

	@Override
	public BookDetailEntity getBookDetailById(long id) {
		return bookdetailRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bookdetail", "Id", id));
	}

	@Override
	public BookDetailEntity updateBookDetail(BookDetailEntity bookdetail, long id) {
		BookDetailEntity existingBookDetail=bookdetailRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("BookDetail", "Id", id));
		existingBookDetail.setQuantity(bookdetail.getQuantity());
		existingBookDetail.setBook_id(bookdetail.getBook_id());
		existingBookDetail.setDetail_id(bookdetail.getDetail_id());
		
		//save toDB
		bookdetailRepository.save(existingBookDetail);
		
		return existingBookDetail;
	}

	@Override
	public void deleteBookDetail(long id) {
		bookdetailRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bookdetail", "Id", id));
		bookdetailRepository.deleteById(id);
	}

}
