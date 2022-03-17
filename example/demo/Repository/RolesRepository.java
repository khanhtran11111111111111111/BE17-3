package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RolesEntity;

@Repository
public interface RolesRepository extends  JpaRepository<RolesEntity, Long>{
	 Optional<RolesEntity> findByName(String name);
}
