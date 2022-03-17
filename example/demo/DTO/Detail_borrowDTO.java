package com.example.demo.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class Detail_borrowDTO {
	private long id;
	private Date Return_date;
	private String Created_by;
	private long Quantity;
	private String Note;
	private int status;
	private Boolean Is_delete= Boolean.FALSE;
	private long user_id;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getReturn_date() {
		return Return_date;
	}
	public void setReturn_date(Date date) {
		Return_date = date;
	}
	public String getCreated_by() {
		return Created_by;
	}
	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}

	
	public long getQuantity() {
		return Quantity;
	}
	public void setQuantity(long quantity) {
		Quantity = quantity;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Boolean getIs_delete() {
		return Is_delete;
	}
	public void setIs_delete(Boolean is_delete) {
		Is_delete = is_delete;
	}
	
	public Detail_borrowDTO( Date return_date, String created_by, long quantity,
			String note, int status, Boolean is_delete, long user_id) {
		super();
	
		Return_date = return_date;
		Created_by = created_by;
		Quantity = quantity;
		Note = note;
		this.status = status;
		Is_delete = is_delete;
		this.user_id = user_id;
	}
	public Detail_borrowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
