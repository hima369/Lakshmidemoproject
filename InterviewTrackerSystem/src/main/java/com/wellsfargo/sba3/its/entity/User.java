package com.wellsfargo.sba3.its.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Data
@Entity  //map class with user table in db
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	@NotNull(message="useId not be empty")
	private Long userId;
	
	@NotNull(message="firstName not be empty")
	@Size(min=5, max=30, message="firstName must be 5 to 30 char in length")	
	private String firstName;
	
	@NotNull(message="lastName not be empty")
	@Size(min=5, max=30, message="lastName must be 5 to 30 char in length")	
	private String lastName;
	
	private String email;
	
	private Long mobile;
	

}
