package com.submission.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

//data annotation will create automatically noArgsConstructor,allArgsConstructor
//,getter,setter,toString,
//equals,hashCode method as well
@Data
public class StudentDto {
	private String firstName;
	private String lastName;
	private String email;
	@JsonProperty(value = "Course_id" ,access = Access.WRITE_ONLY)
	private int courseId;
}
