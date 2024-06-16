package com.submission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.submission.dto.ApiResponse;
import com.submission.dto.DisplayStudentDto;
import com.submission.dto.StudentDto;
import com.submission.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ApiResponse addNewStudent(@RequestBody StudentDto newStudent) {
		try {
			return new ApiResponse(studentService.addNewStudent(newStudent));
		}catch (RuntimeException e) {
			return new ApiResponse(e.getMessage());
		}
	}
	
	@GetMapping("/{courseTitle}")
	public List<DisplayStudentDto> displayStudent(@PathVariable String courseTitle) {
		return studentService.displayStudent(courseTitle);
	}
	
	@DeleteMapping("/{studentId}")
	public ApiResponse removeStudent(@PathVariable int studentId) {
		return studentService.removeStudent(studentId);
	}
	
}
