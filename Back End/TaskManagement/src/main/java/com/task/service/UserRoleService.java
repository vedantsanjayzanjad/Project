package com.task.service;

import com.task.entities.User;
import com.task.entities.UserRoles;

public interface UserRoleService {

	public UserRoles getOne(int id);
	
	public UserRoles getUserRolesByUser(User user);
	
}
