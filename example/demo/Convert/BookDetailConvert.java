package com.example.demo.Convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.BookDetailDTO;
import com.example.demo.Entity.BookDetailEntity;
@Component
public class BookDetailConvert {
	 public BookDetailDTO entityToDto(BookDetailEntity bookdetail)
	 {
		 
		 BookDetailDTO dto= new BookDetailDTO();
		 dto.setId(bookdetail.getId());
		 dto.setQuantity(bookdetail.getQuantity());
		 dto.setIs_delete(bookdetail.getIs_delete());
		 dto.setBook_id(bookdetail.getBook_id());
		 dto.setDetail_id(bookdetail.getDetail_id());
		 
		return dto;
		 
	 }
	 public List<BookDetailDTO> entityToDto(List<BookDetailEntity> alluser){
		 return alluser.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public BookDetailEntity DtoToEntity(BookDetailDTO dto)
	 {	
		 BookDetailEntity bookdetail=new BookDetailEntity();
		 bookdetail.setId(dto.getId());
		 bookdetail.setQuantity(dto.getQuantity());
		 bookdetail.setIs_delete(dto.getIs_delete());
		 bookdetail.setDetail_id(dto.getDetail_id());
		 bookdetail.setBook_id(dto.getBook_id());
		
		 
		 return bookdetail;
	
	 }
	 public List<BookDetailEntity> DtoToEntity(List<BookDetailDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
