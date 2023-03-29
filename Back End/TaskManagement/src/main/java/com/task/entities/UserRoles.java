package com.task.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class UserRoles {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	private Role role;
}
