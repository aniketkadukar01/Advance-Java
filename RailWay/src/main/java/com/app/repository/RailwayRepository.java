package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayRepository extends JpaRepository<Railway, Integer> {
	List<Railway> findByCategory(Category category);
}
