package com.example.demo.Convert;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.User;



@Component
public class UsersConvert {
	 public UsersDTO entityToDto(User user)
	 {
		 
		 UsersDTO dto= new UsersDTO();
		 dto.setId(user.getId());
		 dto.setFullname(user.getFullname());
		 dto.setBirth(user.getBirth());
		 dto.setAddress(user.getAddress());
		 dto.setPhone(user.getPhone());
		 dto.setemail(user.getemail());
		 dto.setSex(user.getSex());
		 dto.setusername(user.getusername());
		 dto.setPassword(user.getPassword());
		 dto.setIs_delete(user.getIs_delete());
		
		 
		return dto;
		 
	 }
	 public List<UsersDTO> entityToDto(List<User> alluser){
		 return alluser.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public User DtoToEntity(UsersDTO dto)
	 {	
		 User user=new User();
		 user.setId(dto.getId());
		 user.setFullname(dto.getFullname());
		 user.setBirth(dto.getBirth());
		 user.setAddress(dto.getAddress());
		 user.setPhone(dto.getPhone());
		 user.setEmail(dto.getemail());
		 user.setSex(dto.getSex());
		 user.setUsername(dto.getusername());
		 user.setPassword(dto.getPassword());
		 user.setIs_delete(dto.getIs_delete());
		
		 
		 return user;
	
	 }
	 public List<User> DtoToEntity(List<UsersDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
