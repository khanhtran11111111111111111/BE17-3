package com.example.demo.Service.IMPL;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.BooksEntity;
import com.example.demo.Repository.BooksRepository;
import com.example.demo.Service.BooksService;
import com.example.demo.exception.ResourceNotFoundException;
@Service

public class BooksServiceimpl implements BooksService{
	private BooksRepository booksRepository;
	public BooksServiceimpl(BooksRepository booksRepository) {
		super();
		this.booksRepository=booksRepository;
	}
	@Override
	public BooksEntity saveBook(BooksEntity book) {
		book.setIs_delete(false);
		book.setCreated_date(new Date());
		return booksRepository.save(book);
	}

	@Override
	public List<BooksEntity> getAllBook() {
		return booksRepository.findAll();
	}

	@Override
	public BooksEntity getBookById(long id) {
		return booksRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book", "Id", id));
	}

	@Override
	public BooksEntity updateBook(BooksEntity book, long id) {
		BooksEntity existingBook=booksRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book", "Id", id));
		existingBook.setBookname(book.getBookname());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setImage(book.getImage());
		existingBook.setInventory(book.getInventory());
		existingBook.setPrice(book.getPrice());
		existingBook.setTotal(book.getTotal());
		existingBook.setUpdate_by(book.getUpdate_by());
		existingBook.setCategory_id(book.getCategory_id());
		existingBook.setUpdate_date(new Date());
		
		
		//save toDB
		booksRepository.save(existingBook);
		
		return existingBook;
	}

	@Override
	public void deleteBook(long id) {
		booksRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book", "Id", id));
		booksRepository.deleteById(id);
		
	}

}
