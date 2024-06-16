package com.submission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.submission.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
