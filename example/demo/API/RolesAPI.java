package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Convert.RolesConvert;
import com.example.demo.DTO.RolesDTO;
import com.example.demo.Entity.RolesEntity;
import com.example.demo.Service.RolesService;


@CrossOrigin
@RestController
@RequestMapping("/api/roles")
public class RolesAPI {
	@Autowired
	RolesConvert rolesConvert;
	@Autowired
	private RolesService rolesService;
	@GetMapping
	public	List<RolesDTO> getAllroles(){
		List<RolesEntity> findAll= rolesService.getAllRoles();
		return rolesConvert.entityToDto(findAll);
	}
}
