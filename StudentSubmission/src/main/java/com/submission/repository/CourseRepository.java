package com.submission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.submission.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
		Course findByCourseTitle(String coursetitle);
}
