package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Convert.BookDetailConvert;
import com.example.demo.DTO.BookDetailDTO;
import com.example.demo.Entity.BookDetailEntity;
import com.example.demo.Service.BookDetailService;

@CrossOrigin
@RestController
@RequestMapping("/api/bookdetail")
public class BookDetailAPI {
	@Autowired
	BookDetailConvert bookDetailConvert;
	@Autowired
	private BookDetailService bookDetailervice;
	//created
	@PostMapping
	@PreAuthorize("hasRole('LIBRARIAN')")
	public BookDetailDTO save(@RequestBody BookDetailDTO dto) {
		BookDetailEntity book = bookDetailConvert.DtoToEntity(dto);
		book=bookDetailervice.saveBookDetail(book);
		return bookDetailConvert.entityToDto(book);
		
        
	}
	//Get all
			@GetMapping
			public	List<BookDetailDTO> getAllbook(){
				List<BookDetailEntity> findAll= bookDetailervice.getAllBookDetail();
				return bookDetailConvert.entityToDto(findAll);
			}
			//Get with id 
			@GetMapping("{id}")
			public	BookDetailDTO findById(@PathVariable(value="id")long id ) {
			BookDetailEntity orElse =bookDetailervice.getBookDetailById(id);
			return bookDetailConvert.entityToDto(orElse);
			}
			@PutMapping("{id}")
			@PreAuthorize("hasRole('LIBRARIAN')")
			public BookDetailDTO updateBook(@PathVariable long id, @RequestBody BookDetailDTO dto) {

				BookDetailEntity book = bookDetailConvert.DtoToEntity(dto);
				book=bookDetailervice.updateBookDetail(book, id);
				return  bookDetailConvert.entityToDto(book);
			}
			//Delete
			@PreAuthorize("hasRole('LIBRARIAN')")
			@DeleteMapping("{id}")
			public ResponseEntity<BookDetailDTO> deleteBook(@PathVariable("id") long id	){
				bookDetailervice.deleteBookDetail(id);
				return new ResponseEntity<BookDetailDTO>(HttpStatus.OK);
			}
}
