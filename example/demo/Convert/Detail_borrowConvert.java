package com.example.demo.Convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.Detail_borrowDTO;
import com.example.demo.Entity.Detail_borrowEntity;

@Component
public class Detail_borrowConvert {
	public Detail_borrowDTO entityToDto(Detail_borrowEntity detailborrow)
	 {
		 
		Detail_borrowDTO dto= new Detail_borrowDTO();
		 dto.setId(detailborrow.getId());
		 dto.setCreated_by(detailborrow.getCreated_by());
		 dto.setReturn_date(detailborrow.getReturn_date());
		 dto.setQuantity(detailborrow.getQuantity());
		 dto.setStatus(detailborrow.getStatus());
		 dto.setNote(detailborrow.getNote());
		 dto.setIs_delete(detailborrow.getIs_delete());
		 dto.setUser_id(detailborrow.getUser_id());
		return dto;
		 
	 }
	 public List<Detail_borrowDTO> entityToDto(List<Detail_borrowEntity> alldetailborrow){
		 return alldetailborrow.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
	 }
	 public Detail_borrowEntity DtoToEntity(Detail_borrowDTO dto)
	 {	
		 Detail_borrowEntity detailborrow=new Detail_borrowEntity();
		 detailborrow.setId(dto.getId());
		 detailborrow.setReturn_date(dto.getReturn_date());
		 detailborrow.setCreated_by(dto.getCreated_by());
		 detailborrow.setQuantity(dto.getQuantity());
		 detailborrow.setStatus(dto.getStatus());
		 detailborrow.setNote(dto.getNote());
		 detailborrow.setIs_delete(dto.getIs_delete());
		 detailborrow.setUser_id(dto.getUser_id());
		 
		 
		 return detailborrow;
	
	 }
	 public List< Detail_borrowEntity> DtoToEntity(List< Detail_borrowDTO> dto)
	 {
		 return dto.stream().map(x->DtoToEntity(x)).collect(Collectors.toList());
	 }
}
