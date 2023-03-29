package com.task.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Holiday;
import com.task.entities.Task;
import com.task.entities.User;
import com.task.payloads.ApiResponse;
import com.task.repository.TaskRepo;
import com.task.repository.UserRepo;
import com.task.service.TaskService;
import com.task.serviceimpl.UserImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/task")
@CrossOrigin(allowedHeaders = "*")
@Slf4j
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserImpl userImpl;

	@Autowired
	private TaskRepo taskrepo;

	@Autowired
	private UserImpl userimpl;

	@PostMapping("/add")
	public ResponseEntity<Task> createTask(@RequestBody Task task) throws Exception {
		log.info("TaskController :: createTask function is started");
		try {
			User userByUsername = this.userimpl.getUserByUsername("NotAssigned");
			task.setUser(userByUsername);			
			Task createTask = this.taskService.createTask(task);
			return new ResponseEntity<>(createTask, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			log.error("TaskController :: Error createTask function "+e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/delete/{taskId}")
	public ResponseEntity<ApiResponse> deleteTaskById(@PathVariable int taskId) {
		log.info("TaskController :: deleteTaskById function is started");
		try 
		{			
			this.taskService.deleteTaskById(taskId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Task is deleted !!!", true), HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			log.error("TaskController :: Error deleteTaskById function "+e.getMessage());
			return null;
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Task>> getAllTask() {
		log.info("TaskController :: getAllTask function is started");
		try 
		{
			List<Task> allTask = this.taskService.getAllTask();
			return new ResponseEntity<List<Task>>(allTask, HttpStatus.ACCEPTED);		
		}
		catch(Exception e)
		{
			log.error("TaskController ::error in getAllTask function "+e.getMessage());
			return null;
		}
	}

	@GetMapping("/getOne/{taskId}")
	public ResponseEntity<Task> getOneTask(@PathVariable int taskId) {
		log.info("TaskController :: getOneTask function is started");
		try 
		{
			Task oneTask = this.taskService.getOneTask(taskId);
			return new ResponseEntity<>(oneTask, HttpStatus.ACCEPTED);			
		}
		catch(Exception e)
		{
			log.error("TaskController :: error in getOneTask "+e.getMessage());
			return null;
		}
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody Task task) {
		log.info("TaskController :: updateTask function is started");
		try 
		{
			Task updateTask = this.taskService.updateTask(taskId, task);
			return new ResponseEntity<>(updateTask, HttpStatus.ACCEPTED);		
		}
		catch(Exception e)
		{
			log.error("TaskController :: error in updateTask "+e.getMessage());
			return null;
		}
	}

	@PostMapping("/tasks/{taskId}")
	public ResponseEntity<Task> createTaskAndUser(@RequestBody Task task, @PathVariable int taskId) throws Exception {
		log.info("TaskController :: createTaskAndUser function is started");
		try 
		{
			Task oneTask = this.taskService.getOneTask(taskId);
			String username = task.getUser().getUsername();
			User userByUsername = this.userImpl.getUserByUsername(username);
			oneTask.setUser(userByUsername);
			this.taskrepo.save(oneTask);
			return new ResponseEntity<>(oneTask, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			log.error("TaskController :: error in createTaskAndUse "+e.getMessage());
			return null;
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Task>> getUserByTask(@PathVariable int id) {
		
		log.info("TaskController :: getUserByTask function is started");
		try
		{
			List<Task> byUser = this.taskService.getByUser(id);
			return new ResponseEntity<List<Task>>(byUser, HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			log.error("TaskController :: error in getUserByTask "+e.getMessage());
			return null;
		}
	}
}
