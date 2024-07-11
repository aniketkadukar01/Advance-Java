package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.RailwayNotFound;
import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.repository.RailwayRepository;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	@Autowired
	private RailwayRepository railwayRepository;
	
	@Override
	public Railway addNewRailway(Railway railway) {
		return railwayRepository.save(railway);
	}

	@Override
	public List<Railway> getAllRailways() {
		return railwayRepository.findAll();
	}

	@Override
	public String deleteRailway(int id) {
		Railway findRailway = railwayRepository.findById(id)
				.orElseThrow(() -> new RailwayNotFound("Railway for this Id is Not Available!!!"));
		railwayRepository.delete(findRailway);
		return "Railway of this Id is deleted Successfully";
	}

	@Override
	public Railway updateRailway(int id ,Railway railway) {
		Railway findRailway = railwayRepository.findById(id)
				.orElseThrow(() -> new RailwayNotFound("Railway for this Id is Not Available!!!"));
		
		  findRailway.setCategory(railway.getCategory());
		  findRailway.setDestination(railway.getDestination());
		  findRailway.setDistance(railway.getDistance());
		  findRailway.setEmail(railway.getEmail());
		  findRailway.setEnd_Date(railway.getEnd_Date());
		  findRailway.setName(railway.getName());
		  findRailway.setSource(railway.getSource());
		  findRailway.setStart_Date(railway.getStart_Date());
		  findRailway.setFrequency(railway.getFrequency());
		 
		return railwayRepository.save(findRailway);
	}

	@Override
	public Railway getById(int id) {
		return railwayRepository.findById(id)
				.orElseThrow(() -> new RailwayNotFound("Railway for this Id is Not Available!!!"));
	}

	@Override
	public List<Railway> sortByCategoryAscending() {
		return railwayRepository.findAll(Sort.by("category"));			
	}

	@Override
	public List<Railway> sortByCategoryDescending() {
		return railwayRepository.findAll(Sort.by(Sort.Direction.DESC,"category"));
	}

	@Override
	public List<Railway> getByCategory(Category category) {
		return railwayRepository.findByCategory(category);
	}

}
