package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "railway",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Railway extends BaseEntity{

	@NotBlank(message = "Name is Mandatory!!!")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Email is Mandatory!!!")
	@Email(message = "Email Format is Invalid!!!")
	@Column(nullable = false,unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Category is Mandatory!!!")
	@Column(nullable = false)
	private Category category;
	
	@NotNull(message = "Start Date is Mandatory!!!")
	@Past(message = "Start Date must be in the past!!!")
	@Column(nullable = false)
	private LocalDate start_Date;
	
	@NotNull(message = "End Date is Mandatory!!!")
	@Column(nullable = false)
	private LocalDate end_Date;
	
	@NotBlank(message = "Source is Mandatory!!!")
	@Column(nullable = false)
	private String source;
	
	@NotBlank(message = "Destinartion is Mandatory!!!")
	@Column(nullable = false)
	private String destination;
	
	@NotBlank(message = "Station code is Mandatory!!!")
	@Column(nullable = false)
	private String stationCode;
	
	@NotNull(message = "Distance is not 0!!!")
	@Column(nullable = false)
	private double distance;
	
	@NotBlank(message = "Frequency is Mandatory!!!")
	@Column(nullable = false)
	private String frequency;
}
