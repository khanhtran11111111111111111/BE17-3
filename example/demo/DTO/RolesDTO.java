package com.example.demo.DTO;

import lombok.Data;

@Data
public class RolesDTO {
	private long id;
	private String Code;
	private String Name;
	private String Description;
	public RolesDTO() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public RolesDTO(String code, String name, String description) {
		super();
		Code = code;
		Name = name;
		Description = description;
	}
	
	
}
