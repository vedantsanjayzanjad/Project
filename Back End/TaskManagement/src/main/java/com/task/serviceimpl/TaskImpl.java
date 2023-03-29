package com.task.serviceimpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Holiday;
import com.task.entities.Task;
import com.task.entities.User;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.HolidayRepo;
import com.task.repository.TaskRepo;
import com.task.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskImpl implements TaskService {

	@Autowired
	private TaskRepo taskRepo;

	@Autowired
	private HolidayRepo holidayRepo;

	@Override
	public Task createTask(Task task) throws Exception {

		log.info("TaskImpl :: createTask function is started ");
		try {
			List<Holiday> holidayDetailsList = holidayRepo.findAll();
			LocalDate startDate = task.getStartDate().plusDays(1);
			int days = task.getDays();
			LocalDate endDate = task.getStartDate();

			for (int i = 0; i < days; i++) {
				endDate = endDate.plus(1, ChronoUnit.DAYS);
				if (endDate.getDayOfWeek() == DayOfWeek.SATURDAY || endDate.getDayOfWeek() == DayOfWeek.SUNDAY
						|| checkholiday(holidayDetailsList, endDate)) {
					days++;
				}
			}
			task.setEndDate(endDate);
			task.setStartDate(startDate);
			System.out.println(startDate + "::Start Date");
			System.out.println(endDate + "::End Date");
			Task save = this.taskRepo.save(task);
			return save;
		} catch (Exception e) {
			log.error("TaskImpl :: Error in createTask " + e.getMessage());
			return null;
		}
	}

	public boolean checkholiday(List<Holiday> holidayDetailsList, LocalDate endDate) {
		for (Holiday holiday : holidayDetailsList) {
			if (holiday.getHolidayDate().isEqual(endDate)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Task> getAllTask() {
		log.info("TaskImpl :: getAllTask function is started ");
		try {
			List<Task> findAll = this.taskRepo.findAll();
			return findAll;
		} catch (Exception e) {
			log.error("TaskImpl :: Error in getAllTask " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteTaskById(int taskId) {
		log.info("TaskImpl :: deleteTaskById function is started ");

		try {
			Task delete = this.taskRepo.findById(taskId)
					.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
			this.taskRepo.delete(delete);
		}

		catch (Exception e) {
			log.error("TaskImpl :: Error in deleteTaskById " + e.getMessage());

		}

	}

	@Override
	public Task getOneTask(int taskId) {
		log.info("TaskImpl :: getOneTask function is started ");
		try {
			Task task = this.taskRepo.findById(taskId)
					.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
			return task;
		} catch (Exception e) {
			log.error("TaskImpl :: Error in getOneTask " + e.getMessage());
			return null;

		}
	}

	@Override
	public Task updateTask(int taskId, Task task) {
		log.info("TaskImpl :: updateTask function is started ");

		try {
			Task updateTask = this.taskRepo.findById(taskId)
					.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
			List<Holiday> holidayDetailsList = holidayRepo.findAll();
			LocalDate startDate = task.getStartDate().plusDays(1);
			System.out.println(startDate);
			System.out.println(startDate.plusDays(1));
			int days = task.getDays();
			System.out.println(days);
			LocalDate endDate = task.getStartDate();
			System.out.println(endDate);

			for (int i = 0; i < days; i++) {
				endDate = endDate.plus(1, ChronoUnit.DAYS);
				if (endDate.getDayOfWeek() == DayOfWeek.SATURDAY || endDate.getDayOfWeek() == DayOfWeek.SUNDAY
						|| checkholiday(holidayDetailsList, endDate)) {
					days++;
				}
			}

			updateTask.setStartDate(startDate);
			updateTask.setDays(task.getDays());
			System.out.println(task.getDays());
			updateTask.setEndDate(endDate);
			System.out.println(startDate + "::Start Date");
			System.out.println(endDate + "::End Date");
			updateTask.setTaskDescription(task.getTaskDescription());
			Task save = this.taskRepo.save(updateTask);
			return save;
		} catch (Exception e) {
			log.error("TaskImpl :: Error in updateTask " + e.getMessage());
			return null;

		}
	}

	@Override
	public List<Task> getByUser(int id) {
		log.info("TaskImpl :: getByUser function is started ");
		try {
			List<Task> findByUserId = this.taskRepo.findByUserId(id);
			return findByUserId;
		} catch (Exception e) {
			log.error("TaskImpl :: Error in getByUser " + e.getMessage());
			return null;

		}
	}

}
