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

import com.example.demo.Convert.CategoriesConvert;
import com.example.demo.DTO.CategoriesDTO;
import com.example.demo.Entity.CategoriesEntity;
import com.example.demo.Service.CategoriesService;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoriesAPI {
	@Autowired
	CategoriesConvert categoriesConvert;
	@Autowired
	private CategoriesService categoriesService;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public CategoriesDTO save(@RequestBody CategoriesDTO dto) {
		CategoriesEntity categories = categoriesConvert.DtoToEntity(dto);
		categories=categoriesService.saveCategory(categories);
		return categoriesConvert.entityToDto(categories);
		
        
	}
	//Get all
		@GetMapping
		public	List<CategoriesDTO> getAllCategory(){
			List<CategoriesEntity> findAll= categoriesService.getAllCategory();
			return categoriesConvert.entityToDto(findAll);
		}
		
		//Get with id 
		@GetMapping("{id}")
		public	CategoriesDTO findById(@PathVariable(value="id")long id ) {
			CategoriesEntity orElse =categoriesService.getCategoryById(id);
		return categoriesConvert.entityToDto(orElse);
		}
		//Update
		@PreAuthorize("hasRole('ADMIN')")
		@PutMapping("{id}")
		public CategoriesDTO updateCategory(@PathVariable long id, @RequestBody CategoriesDTO dto) {

			CategoriesEntity categories = categoriesConvert.DtoToEntity(dto);
			categories=categoriesService.updateCategory(categories, id);
			return  categoriesConvert.entityToDto(categories);
		}
		//Delete
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("{id}")
		public ResponseEntity<CategoriesDTO> deleteCategories(@PathVariable("id") long id	){
			categoriesService.deleteCategories(id);
			return new ResponseEntity<CategoriesDTO>(HttpStatus.OK);
		}
}
