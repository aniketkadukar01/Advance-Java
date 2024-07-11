package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.service.RailwayService;

@RestController
@RequestMapping("/api/Railways")
public class RailwayController {
	
	@Autowired
	private RailwayService railwayService;

	@PostMapping("/AddNewRailway")
	public ResponseEntity<Railway> addNewRailway(@Valid @RequestBody Railway railway){
		return ResponseEntity.ok(railwayService.addNewRailway(railway));
	}
	
	@GetMapping("/GetAllRailways")
	public ResponseEntity<List<Railway>> getAllRailway(){
		return ResponseEntity.ok(railwayService.getAllRailways());
	}
	
	@DeleteMapping("/DeleteRailway/{id}")
	public ResponseEntity<String> deleteRailway(@PathVariable int id){
		return ResponseEntity.ok(railwayService.deleteRailway(id));
	}
	
	@PutMapping("/UpdateRailway/{id}")
	public ResponseEntity<Railway> updateRailway(@PathVariable int id
			,@Valid @RequestBody Railway railway){
		return ResponseEntity.ok(railwayService.updateRailway(id,railway));
	}
	
	@GetMapping("/GetById/{id}")
	public ResponseEntity<Railway> getById(@PathVariable int id){
		return ResponseEntity.ok(railwayService.getById(id));
	}
	
	@GetMapping("/SortByCategoryAscending")
	public ResponseEntity<List<Railway>> sortByCategoryAscending(){
		return ResponseEntity.ok(railwayService.sortByCategoryAscending());
	}
	
	@GetMapping("/SortByCategoryDescending")
	public ResponseEntity<List<Railway>> sortByCategoryDescending(){
		return ResponseEntity.ok(railwayService.sortByCategoryDescending());
	}
	
	@GetMapping("/GetByCategory/{category}")
	public ResponseEntity<List<Railway>> GetByCategory(@PathVariable Category category){
		return ResponseEntity.ok(railwayService.getByCategory(category));
	}
	
}
