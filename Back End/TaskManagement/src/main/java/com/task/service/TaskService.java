package com.task.service;

import java.util.List;

import com.task.entities.Task;
import com.task.entities.User;

public interface TaskService {
	public Task createTask(Task task) throws Exception;

	public List<Task> getAllTask();

	public void deleteTaskById(int taskId);

	public Task getOneTask(int taskId);

	public Task updateTask(int taskId, Task task);
	
	public List<Task> getByUser(int id);
}
