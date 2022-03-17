package com.example.demo.Service.IMPL;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Detail_borrowEntity;
import com.example.demo.Repository.Detail_borrowRepository;
import com.example.demo.Service.Detail_borrowService;
import com.example.demo.exception.ResourceNotFoundException;


@Service
public class Detail_borrowServiceimpl implements Detail_borrowService{
	private Detail_borrowRepository detail_borrowRepository;
	public Detail_borrowServiceimpl(Detail_borrowRepository detail_borrowRepository) {
		super();
		this.detail_borrowRepository=detail_borrowRepository;
	}
	@Override
	public Detail_borrowEntity saveDetail_borrow(Detail_borrowEntity detail_borrow) {
		detail_borrow.setIs_delete(false);
		detail_borrow.setCreated_date(new Date());
		detail_borrow.setStatus(1);
		return detail_borrowRepository.save(detail_borrow);
	}

	@Override
	public List<Detail_borrowEntity> getAllDetail_borrow() {
		return detail_borrowRepository.findAll();
	}

	@Override
	public Detail_borrowEntity getDetail_borrowById(long id) {
		return detail_borrowRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Detail_borrow", "Id", id));
	}

	@Override
	public Detail_borrowEntity updateDetail_borrow(Detail_borrowEntity user, long id) {
		Detail_borrowEntity existingDetail_borrow=detail_borrowRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Detail_borrow", "Id", id));
		existingDetail_borrow.setCreated_by(user.getCreated_by());
		existingDetail_borrow.setReturn_date(user.getReturn_date());
		existingDetail_borrow.setQuantity(user.getQuantity());
		existingDetail_borrow.setNote(user.getNote());
		existingDetail_borrow.setIs_delete(user.getIs_delete());
		existingDetail_borrow.setStatus(user.getStatus());
		existingDetail_borrow.setUser_id(user.getUser_id());
		existingDetail_borrow.setUpdate_date(new Date());
		
		
		//save toDB
		detail_borrowRepository.save(existingDetail_borrow);
		
		return existingDetail_borrow;
	}

	@Override
	public void deleteDetail_borrow(long id) {
		// TODO Auto-generated method stub
				detail_borrowRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
				detail_borrowRepository.deleteById(id);
	}

}
