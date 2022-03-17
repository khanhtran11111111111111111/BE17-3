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

import com.example.demo.Convert.Detail_borrowConvert;
import com.example.demo.Convert.UsersConvert;
import com.example.demo.DTO.Detail_borrowDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.Detail_borrowEntity;
import com.example.demo.Service.Detail_borrowService;



@CrossOrigin
@RestController
@RequestMapping("/api/detailborrow")
public class Detail_borrowAPI {
	@Autowired
	Detail_borrowConvert detail_borrowConvert;
	@Autowired
	private Detail_borrowService detail_borrowService;
	// created
	@PreAuthorize("hasRole('LIBRARIAN')")
	@PostMapping
	public Detail_borrowDTO save(@RequestBody Detail_borrowDTO dto) {
		Detail_borrowEntity detail_borrow = detail_borrowConvert.DtoToEntity(dto);
		detail_borrow=detail_borrowService.saveDetail_borrow(detail_borrow);
		return detail_borrowConvert.entityToDto(detail_borrow);
		
        
	}
	//Get all
	@GetMapping
	public	List<Detail_borrowDTO> getAllDetail_borrow(){
		List<Detail_borrowEntity> findAll= detail_borrowService.getAllDetail_borrow();
		return detail_borrowConvert.entityToDto(findAll);
	}
	//Get with id 
	
	@GetMapping("{id}")
	public	Detail_borrowDTO findById(@PathVariable(value="id")long id ) {
		Detail_borrowEntity orElse =detail_borrowService.getDetail_borrowById(id);
	return detail_borrowConvert.entityToDto(orElse);
	}
	//Update
	@PreAuthorize("hasRole('LIBRARIAN')")
			@PutMapping("{id}")
			public Detail_borrowDTO updateDetail_borrow(@PathVariable long id, @RequestBody Detail_borrowDTO dto) {

				Detail_borrowEntity detail_borrow = detail_borrowConvert.DtoToEntity(dto);
				detail_borrow=detail_borrowService.updateDetail_borrow(detail_borrow, id);
				return  detail_borrowConvert.entityToDto(detail_borrow);
			}
			//Delete
	@PreAuthorize("hasRole('LIBRARIAN')")
			@DeleteMapping("{id}")
			public ResponseEntity<Detail_borrowDTO> deleteDetail_borrow(@PathVariable("id") long id	){
				detail_borrowService.deleteDetail_borrow(id);
				return new ResponseEntity<Detail_borrowDTO>(HttpStatus.OK);
			}
		
}
