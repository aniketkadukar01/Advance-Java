package com.submission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.submission.dto.ApiResponse;
import com.submission.dto.CourseDto;
import com.submission.entity.Course;
import com.submission.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping //adding new courses
	public ResponseEntity<ApiResponse> addNewCourses(@RequestBody Course newCourse) {
		try {
			ApiResponse apiResponse = courseService.addNewCourse(newCourse);
			return ResponseEntity.ok(apiResponse);
		}catch (RuntimeException e) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return null;
	}
	
	@PutMapping // update courses
	public ResponseEntity<?> updateCourseFees(@RequestBody CourseDto courseDto){
		try {
			Course newCourse = courseService.updateCourse(courseDto);
			return ResponseEntity.ok(newCourse);
		}catch (RuntimeException e) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return null;
	}
	
	@DeleteMapping("/{courseId}")
	public ApiResponse removeCourse(@PathVariable int courseId) {
		return courseService.removeCourse(courseId);
	}

}
