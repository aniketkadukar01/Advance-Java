package com.submission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.submission.custom_exception.CustomException;
import com.submission.dto.ApiResponse;
import com.submission.dto.CourseDto;
import com.submission.entity.Course;
import com.submission.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
		
	
	@Override
	public ApiResponse addNewCourse(Course newCourse) {
		if(courseRepository.findByCourseTitle(newCourse.getCourseTitle())!=null) {
			 throw new CustomException("title is already exists!!!");
		}
		courseRepository.save(newCourse);
		return new ApiResponse("New Course Added Successfully");
	}


	@Override
	public Course findCourseByTitle(String courseTitle) {
		return courseRepository.findByCourseTitle(courseTitle);
	}


	@Override
	public Course updateCourse(CourseDto courseDto) {
		Course newCourse = courseRepository.findById(courseDto.getCourseId())
				.orElseThrow(() -> new RuntimeException("course not found"));
		
		newCourse.setFees(courseDto.getUpdatedFees());
		return courseRepository.save(newCourse);
		
	}


	@Override
	public Course findCourseById(int courseId) {
		 return courseRepository.findById(courseId)
				 .orElseThrow(() -> new CustomException("Id is already exists!!!"));
	}


	@Override
	public ApiResponse removeCourse(int courseId) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
			return new ApiResponse("course removed successfully!!!");
		}
		else
			return new ApiResponse("course id not found");
	
		
	}

}
