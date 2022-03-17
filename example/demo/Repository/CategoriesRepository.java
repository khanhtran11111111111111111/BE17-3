package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CategoriesEntity;
@Repository
public interface CategoriesRepository extends  JpaRepository<CategoriesEntity, Long>{

}
