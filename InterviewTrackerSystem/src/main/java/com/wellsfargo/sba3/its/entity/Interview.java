package com.wellsfargo.sba3.its.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
public class Interview implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long interviewId;
	
	@NotBlank(message="interviewrName can not be blank")
	@NotNull(message="interviewrName cannot be null")
	private String interviewerName;
	
	@NotBlank(message="interviewName can not be blank")
	@NotNull(message="interviewName cannot be null")
	private String interviewName;
	
	@NotBlank(message="userSkills can not be blank")
	@NotNull(message="userSkills cannot be null")
	private String userSkills;
	
	@DateTimeFormat(iso=ISO.TIME)
	private LocalDate time;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	
	@NotBlank(message="interviewStatus cannot be blank")
	@NotNull(message="interviewStatus cannot be null")
	@Size(min=5,max=100,message="Interview Status should be of length between 5 and 100")
	private String interviewStatus;
	
	@NotBlank(message="Remarks cannot be blank")
	@NotNull(message="Remarks cannot be null")
	private String remarks;
	

}
