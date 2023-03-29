package com.task.entities;

import java.util.HashSet;


import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Long phone;
	
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	@JsonIgnore
	private Set<UserRoles> userRole = new HashSet<>(); 
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.MERGE)
	@JsonIgnore
	private Set<Task> task = new HashSet<>();
}
