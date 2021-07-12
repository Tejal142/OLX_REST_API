package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.entity.CatEntity;
import com.olx.repo.CatRepo;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	private CatRepo categoryRepo;
	
	@Override
	public List<Category> getAllCategories() {
		List<CatEntity> categoryEntities = categoryRepo.findAll();
		List<Category> categories = new ArrayList<>();
		categoryEntities.stream().forEach((categoryEntity)->categories.add(new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription())));
		return categories;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		Optional<CatEntity> opCategoryEntity = categoryRepo.findById(categoryId);
		if(opCategoryEntity.isPresent()) {
			CatEntity categoryEntity = opCategoryEntity.get();
			return new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
		}
		return null;
	}

}
