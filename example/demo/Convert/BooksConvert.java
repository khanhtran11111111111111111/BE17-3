package com.example.demo.Convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.BooksDTO;
import com.example.demo.Entity.BooksEntity;
@Component
public class BooksConvert {
	 public BooksDTO entityToDto(BooksEntity book)
	 {
		 
		 BooksDTO dto= new BooksDTO();
		 dto.setId(book.getId());
		 dto.setBookname(book.getBookname());
		 dto.setAuthor(book.getAuthor());
		 dto.setImage(book.getImage());
		 dto.setInventory(book.getInventory());
		 dto.setPrice(book.getPrice());
		 dto.setTotal(book.getTotal());
		 dto.setCreated_by(book.getCreated_by());
		 dto.setUpdate_by(book.getUpdate_by());
		 dto.setIs_delete(book.getIs_delete());
		 dto.setCategory_id(book.getCategory_id());
		 
		return dto;
		 
	 }
	 public List<BooksDTO> entityToDto(List<BooksEntity> allbook){
		 return allbook.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public BooksEntity DtoToEntity(BooksDTO dto)
	 {	
		 BooksEntity book=new BooksEntity();
		 book.setId(dto.getId());
		 book.setBookname(dto.getBookname());
		 book.setAuthor(dto.getAuthor());
		 book.setImage(dto.getImage());
		 book.setInventory(dto.getInventory());
		 book.setTotal(dto.getTotal());
		 book.setPrice(dto.getPrice());
		 book.setCreated_by(dto.getCreated_by());
		 book.setUpdate_by(dto.getUpdate_by());
		 book.setIs_delete(dto.getIs_delete());
		 book.setCategory_id(dto.getCategory_id());
		 
		 return book;
	
	 }
	 public List<BooksEntity> DtoToEntity(List<BooksDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
