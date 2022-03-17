package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.BookDetailEntity;
@Repository
public interface BookDetailRepository extends  JpaRepository<BookDetailEntity, Long>{

}
