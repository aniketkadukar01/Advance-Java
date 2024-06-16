package com.submission.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course extends SuperEntity{
	private String courseTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private double score;
	@OneToMany(mappedBy = "courseId" , fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Student> studentList = new ArrayList<Student>();
	
	public void addStudent(Student newStudent) {
		studentList.add(newStudent);
		newStudent.setCourseId(this);
	}
	
	public void removeStudent(Student newStudent) {
		studentList.remove(newStudent);
		newStudent.setCourseId(null);
	}
	
}
