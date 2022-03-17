package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Detail_borrowEntity;


public interface Detail_borrowService {
	Detail_borrowEntity saveDetail_borrow(Detail_borrowEntity detail_borrow);
	List<Detail_borrowEntity> getAllDetail_borrow();
	Detail_borrowEntity getDetail_borrowById(long id);
	Detail_borrowEntity updateDetail_borrow(Detail_borrowEntity user, long id);
	void deleteDetail_borrow(long id);

}
