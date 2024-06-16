package com.submission.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.submission.dto.ApiResponse;
import com.submission.dto.DisplayStudentDto;
import com.submission.dto.StudentDto;
import com.submission.entity.Course;
import com.submission.entity.Student;
import com.submission.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseService courseService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String addNewStudent(StudentDto newStudent) {

		Course newCourse = courseService.findCourseById(newStudent.getCourseId());

		Student newStudent2 = mapper.map(newStudent, Student.class);

		if (newCourse != null) {
			newCourse.addStudent(newStudent2);
		}
		studentRepository.save(newStudent2);
		return "New Student Added Successfully";
	}

	@Override
	public List<DisplayStudentDto> displayStudent(String courseTitle) {

		Course newCourse = courseService.findCourseByTitle(courseTitle);
		if (newCourse != null) {
			return studentRepository.findAll().stream()
					.filter(student -> student.getCourseId().getId() == newCourse.getId())
					.map(student -> mapper.map(student, DisplayStudentDto.class)).collect(Collectors.toList());
		} else {
			return List.of();
		}
	}

	@Override
	public ApiResponse removeStudent(int studentId) {
		if (studentRepository.existsById(studentId)) {
			studentRepository.deleteById(studentId);
			return new ApiResponse("student deleted sucessfully");
		} else {
			return new ApiResponse("Invalid Student ID!!");
		}
	}


}
