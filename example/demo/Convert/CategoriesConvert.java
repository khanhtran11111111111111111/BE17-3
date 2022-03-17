package com.example.demo.Convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.CategoriesDTO;
import com.example.demo.Entity.CategoriesEntity;
@Component
public class CategoriesConvert {
	 public CategoriesDTO entityToDto(CategoriesEntity category)
	 {
		 
		 CategoriesDTO dto= new CategoriesDTO();
		 dto.setId(category.getId());
		 dto.setCategoryname(category.getCategoryname());
		 dto.setCode(category.getCode());
		 dto.setDescription(category.getDescription());
		 dto.setCreated_by(category.getCreated_by());
		 dto.setUpdate_by(category.getUpdate_by());
		 dto.setIs_delete(category.getIs_delete());
		return dto;
		 
	 }
	 public List<CategoriesDTO> entityToDto(List<CategoriesEntity> allcategory){
		 return allcategory.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public CategoriesEntity DtoToEntity(CategoriesDTO dto)
	 {	
		 CategoriesEntity category=new CategoriesEntity();
		 category.setId(dto.getId());
		 category.setCategoryname(dto.getCategoryname());
		 category.setCode(dto.getCode());
		 category.setDescription(dto.getDescription());
		 category.setCreated_by(dto.getCreated_by());
		 category.setUpdate_by(dto.getUpdate_by());
		 category.setIs_delete(dto.getIs_delete());
		 
		 return  category;
	
	 }
	 public List<CategoriesEntity> DtoToEntity(List<CategoriesDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
