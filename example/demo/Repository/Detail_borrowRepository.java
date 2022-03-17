package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Detail_borrowEntity;

@Repository
public interface Detail_borrowRepository extends  JpaRepository<Detail_borrowEntity, Long>{

}
