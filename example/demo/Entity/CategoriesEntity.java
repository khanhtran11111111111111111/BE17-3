package com.example.demo.Entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@EnableTransactionManagement

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
@SQLDelete(sql = "UPDATE categories SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class CategoriesEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="categoryname")
	private String Categoryname;	
	
	@Column(name="code")
	private String Code;
	@Column(name="description")
	private String Description;
	@Column(name="created_by")
	private String Created_by;
	@Column(name="update_by")
	private String Update_by;
	@Temporal(TemporalType.TIMESTAMP)
	private Date Created_date=new Date();
	@Column(name="update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Update_date=new Date();
	@Column(name="is_delete")
	private Boolean Is_delete= Boolean.FALSE;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id",referencedColumnName = "id")
	List<BooksEntity> booksEntities=new ArrayList<>();
	
	public List<BooksEntity> getBooksEntities() {
		return booksEntities;
	}
	public void setBooksEntities(List<BooksEntity> booksEntities) {
		this.booksEntities = booksEntities;
	}
	public CategoriesEntity()
	{
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getCreated_date() {
		return Created_date;
	}
	public void setCreated_date(Date created_date) {
		Created_date = created_date;
	}
	public String getUpdate_by() {
		return Update_by;
	}
	public void setUpdate_by(String update_by) {
		Update_by = update_by;
	}
	public Date getUpdate_date() {
		return Update_date;
	}
	public void setUpdate_date(Date update_date) {
		Update_date = update_date;
	}
	public Boolean getIs_delete() {
		return Is_delete;
	}
	public void setIs_delete(Boolean is_delete) {
		Is_delete = is_delete;
	}
	public CategoriesEntity(String categoryname, String code, String description, String created_by, Date created_date,
			String update_by, Date update_date, Boolean is_delete) {
		super();
		Categoryname = categoryname;
		Code = code;
		Description = description;
		Created_by = created_by;
		Created_date = created_date;
		Update_by = update_by;
		Update_date = update_date;
		Is_delete = is_delete;
	}
	

	



}