package com.task.entities;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
//	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	private int days;

//	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	private String taskDescription;
	
	@ManyToOne(fetch  = FetchType.EAGER,cascade = CascadeType.MERGE)
	private User user;
}
