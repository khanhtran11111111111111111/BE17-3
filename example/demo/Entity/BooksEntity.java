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
@Table(name="books")
@SQLDelete(sql = "UPDATE books SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class BooksEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="bookname")
	private String Bookname;
	@Column(name="author")
	private String Author;
	@Column(name="image")
	private String Image;
	@Column(name="price")
	private long Price;
	@Column(name="total")
	private long Total;
	@Column(name="inventory")
	private long Inventory;
	@Column(name="created_by")
	private String Created_by;
	@Column(name="update_by")
	private String Update_by;
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Created_date=new Date();
	@Column(name="update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Update_date=new Date();
	@Column(name="is_delete")
	private Boolean Is_delete= Boolean.FALSE;
	@Column(name="category_id")
	private long Category_id;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id",referencedColumnName = "id")
	List<BookDetailEntity> booksEntities=new ArrayList<>();

	public List<BookDetailEntity> getBooksEntities() {
		return booksEntities;
	}


	public void setBooksEntities(List<BookDetailEntity> booksEntities) {
		this.booksEntities = booksEntities;
	}


	public BooksEntity() {}
	

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


	public BooksEntity(String bookname, String author, String image, long price, long total, long inventory,
			String created_by, String update_by, Date created_date, Date update_date, Boolean is_delete,
			long category_id, List<BookDetailEntity> booksEntities) {
		super();
		Bookname = bookname;
		Author = author;
		Image = image;
		Price = price;
		Total = total;
		Inventory = inventory;
		Created_by = created_by;
		Update_by = update_by;
		Created_date = created_date;
		Update_date = update_date;
		Is_delete = is_delete;
		this.Category_id = category_id;
		this.booksEntities = booksEntities;
	}
	


}
