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

import com.example.demo.Convert.BooksConvert;
import com.example.demo.DTO.BooksDTO;
import com.example.demo.Entity.BooksEntity;
import com.example.demo.Service.BooksService;



@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BooksAPI {
	@Autowired
	BooksConvert booksConvert;
	@Autowired
	private BooksService bookService;
	//created
	@PreAuthorize("hasRole('LIBRARIAN')")
	@PostMapping
	public BooksDTO save(@RequestBody BooksDTO dto) {
		BooksEntity book = booksConvert.DtoToEntity(dto);
		book=bookService.saveBook(book);
		return booksConvert.entityToDto(book);
		
        
	}
	//Get all
			@GetMapping
			public	List<BooksDTO> getAllbook(){
				List<BooksEntity> findAll= bookService.getAllBook();
				return booksConvert.entityToDto(findAll);
			}
			//Get with id 
			@GetMapping("{id}")
			public	BooksDTO findById(@PathVariable(value="id")long id ) {
			BooksEntity orElse =bookService.getBookById(id);
			return booksConvert.entityToDto(orElse);
			}
			@PreAuthorize("hasRole('LIBRARIAN')")
			@PutMapping("{id}")
			public BooksDTO updateBook(@PathVariable long id, @RequestBody BooksDTO dto) {

				BooksEntity book = booksConvert.DtoToEntity(dto);
				book=bookService.updateBook(book, id);
				return  booksConvert.entityToDto(book);
			}
			//Delete
			@PreAuthorize("hasRole('LIBRARIAN')")
			@DeleteMapping("{id}")
			public ResponseEntity<BooksDTO> deleteBook(@PathVariable("id") long id	){
				bookService.deleteBook(id);
				return new ResponseEntity<BooksDTO>(HttpStatus.OK);
			}
}
