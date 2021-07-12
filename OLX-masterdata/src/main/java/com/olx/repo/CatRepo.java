package com.olx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.CatEntity;

public interface CatRepo extends JpaRepository<CatEntity, Long>{

}
