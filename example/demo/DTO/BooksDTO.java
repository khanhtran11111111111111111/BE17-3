package com.example.demo.DTO;


import lombok.Data;

@Data
public class BooksDTO {
	private long id;
	private String Bookname;	
	private String Author;
	private String Image;
	private long Price;
	private long Total;
	private long Inventory;
	private String Created_by;
	private String Update_by;
	private Boolean Is_delete= Boolean.FALSE;
	private long Category_id;
	public BooksDTO() {}
	
	public long getCategory_id() {
		return Category_id;
	}

	public void setCategory_id(long category_id) {
		this.Category_id = category_id;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public long getTotal() {
		return Total;
	}
	public void setTotal(long total) {
		Total = total;
	}
	public long getInventory() {
		return Inventory;
	}
	public void setInventory(long inventory) {
		Inventory = inventory;
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

	public BooksDTO(String bookname, String author, String image, long price, long total, long inventory,
			String created_by, String update_by, Boolean is_delete, long category_id) {
		super();
		Bookname = bookname;
		Author = author;
		Image = image;
		Price = price;
		Total = total;
		Inventory = inventory;
		Created_by = created_by;
		Update_by = update_by;
		Is_delete = is_delete;
		this.Category_id = category_id;
	}

	
}
