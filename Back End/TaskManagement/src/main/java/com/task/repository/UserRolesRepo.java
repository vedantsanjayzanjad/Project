package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.User;
import com.task.entities.UserRoles;

public interface UserRolesRepo extends JpaRepository<UserRoles, Integer>{

	public UserRoles findByuser(User user);
}
