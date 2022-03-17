package com.example.demo.Convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.RolesDTO;
import com.example.demo.Entity.RolesEntity;

@Component
public class RolesConvert {

	 public RolesDTO entityToDto(RolesEntity roles)
	 {
		 
		 RolesDTO dto= new RolesDTO();
		 dto.setId(roles.getId());
		 dto.setName(roles.getName());
		 dto.setCode(roles.getCode());
		 dto.setDescription(roles.getDescription());
		 
		return dto;
		 
	 }
	 public List<RolesDTO> entityToDto(List<RolesEntity> allrole){
		 return allrole.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public RolesEntity DtoToEntity(RolesDTO dto)
	 {	
		 RolesEntity roles=new RolesEntity();
		 roles.setId(dto.getId());
		 roles.setName(dto.getName());
		 roles.setCode(dto.getCode());
		 roles.setDescription(dto.getDescription());
		 
		 return roles;
	
	 }
	 public List<RolesEntity> DtoToEntity(List<RolesDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
