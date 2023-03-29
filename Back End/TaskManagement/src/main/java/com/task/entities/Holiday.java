package com.task.entities;

import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int holidayId;

//	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate holidayDate;
	
	private String holidayName;
}
