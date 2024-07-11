package com.app.service;

import java.util.List;

import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayService {
	
	Railway addNewRailway(Railway railway);
	
	List<Railway> getAllRailways();
	
	String deleteRailway(int id);
	
	Railway updateRailway(int id ,Railway railway);
	
	Railway getById(int id);
	
	List<Railway> sortByCategoryAscending();
	
	List<Railway> sortByCategoryDescending();
	
	List<Railway> getByCategory(Category category);
}
