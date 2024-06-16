package com.submission.service;

import java.util.List;

import com.submission.dto.ApiResponse;
import com.submission.dto.DisplayStudentDto;
import com.submission.dto.StudentDto;

public interface StudentService {
	String addNewStudent(StudentDto  newStudent);

	List<DisplayStudentDto> displayStudent(String courseTitle);

	ApiResponse removeStudent(int studentId);
	
}
