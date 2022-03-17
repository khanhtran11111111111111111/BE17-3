	package com.example.demo.API;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Convert.UsersConvert;
import com.example.demo.DTO.RolesDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.RolesEntity;
import com.example.demo.Entity.User;

import com.example.demo.Service.UsersService;



@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersAPI {
	@Autowired
	UsersConvert usersConvert;
	@Autowired
	private UsersService userService;
	// created
	 @PreAuthorize("hasRole('ADMIN')")
	@PostMapping 
	public ResponseEntity<UsersDTO> save(@Validated @RequestBody UsersDTO dto) {		
		User saveuser = usersConvert.DtoToEntity(dto);
		saveuser=userService.saveUser(saveuser);
		return new  ResponseEntity<UsersDTO>(HttpStatus.CREATED);
	}
	
	//Get all
		@GetMapping
		public	List<UsersDTO> getAlluser(){
			List<User> findAll= userService.getAllUser();
			return usersConvert.entityToDto(findAll);
		}
		
		//Get with id 
		@GetMapping("{id}")
		public	UsersDTO findById(@PathVariable(value="id")long id ) {
		User orElse =userService.getUserById(id);
		return usersConvert.entityToDto(orElse);
		}
		//Update
		@PreAuthorize("hasRole('ADMIN')")
		@PutMapping("{id}")
		public UsersDTO updateUser(@PathVariable long id, @RequestBody UsersDTO dto) {

			User user = usersConvert.DtoToEntity(dto);
			user=userService.updateUser(user, id);
			return  usersConvert.entityToDto(user);
		}
		//Delete
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("{id}")
		public ResponseEntity<UsersDTO> deleteUser(@PathVariable("id") long id	){
			userService.deleteUser(id);
			return new ResponseEntity<UsersDTO>(HttpStatus.OK);
		}
}
