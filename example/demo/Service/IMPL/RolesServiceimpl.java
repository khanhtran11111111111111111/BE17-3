package com.example.demo.Service.IMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.RolesEntity;
import com.example.demo.Repository.RolesRepository;
import com.example.demo.Service.RolesService;

 

@Service
public class RolesServiceimpl implements RolesService{
	private RolesRepository rolesRepository;
	public RolesServiceimpl(RolesRepository rolesRepository) {
		super();
		this.rolesRepository=rolesRepository;
	}
	@Override
	public List<RolesEntity> getAllRoles() {
		return rolesRepository.findAll();
	}
	

	
}
