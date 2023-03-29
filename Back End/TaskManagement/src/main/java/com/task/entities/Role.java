package com.task.entities;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
public class Role {

	@Id
	private int roleId;
	
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	private Set<UserRoles> userRole = new HashSet<>(); 
	
}

