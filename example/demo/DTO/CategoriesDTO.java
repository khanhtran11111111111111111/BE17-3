package com.example.demo.DTO;





import lombok.Data;

@Data
public class CategoriesDTO {
	private long category_id;
	private String Categoryname;	
	private String Code;
	private String Description;
	private String Created_by;
	private String Update_by;
	private Boolean Is_delete= Boolean.FALSE;
	public CategoriesDTO() {}
	public long getId() {
		return category_id;
	}
	public void setId(long id) {
		this.category_id = id;
	}
	public String getCategoryname() {
		return Categoryname;
	}
	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCreated_by() {
		return Created_by;
	}
	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}
	
	public String getUpdate_by() {
		return Update_by;
	}
	public void setUpdate_by(String update_by) {
		Update_by = update_by;
	}
	
	public Boolean getIs_delete() {
		return Is_delete;
	}
	public void setIs_delete(Boolean is_delete) {
		Is_delete = is_delete;
	}
	public CategoriesDTO(String categoryname, String code, String description, String created_by,
			String update_by,  Boolean is_delete) {
		super();
		Categoryname = categoryname;
		Code = code;
		Description = description;
		Created_by = created_by;
		
		Update_by = update_by;
	
		Is_delete = is_delete;
	}
	
}
