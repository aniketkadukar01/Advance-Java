package com.submission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "courseId")
public class Student extends SuperEntity{
	
	private String firstName;
	private String lastName;
	@Column(unique = true ,nullable = false)
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id",nullable = false)
	private Course courseId;

}
