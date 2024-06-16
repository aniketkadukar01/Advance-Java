package com.submission.service;

import com.submission.dto.ApiResponse;
import com.submission.dto.CourseDto;
import com.submission.entity.Course;

public interface CourseService {
	ApiResponse addNewCourse(Course newCourse);

	Course findCourseByTitle(String courseTitle);

	Course updateCourse(CourseDto courseDto);
	
	Course findCourseById(int courseId);

	ApiResponse removeCourse(int courseId);
}
