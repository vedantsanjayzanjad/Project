package com.task.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Holiday;
import com.task.payloads.ApiResponse;
import com.task.serviceimpl.HolidayImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/holiday")
@CrossOrigin(allowedHeaders = "*")
@Slf4j
public class HolidayController {

	@Autowired
	private HolidayImpl holidayserv;

	@PostMapping("/add")
	public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) throws Exception {
		log.info("HolidayController :: createHoliday function is started");
		try 
		{
			Holiday createHoliday = this.holidayserv.createHoliday(holiday);
			return new ResponseEntity<>(createHoliday, HttpStatus.ACCEPTED);		
		}
		catch(Exception e)
		{
			log.info("HolidayController :: Error createHoliday function " + e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/delete/{holidayId}")
	public ResponseEntity<ApiResponse> deleteHolidayById(@PathVariable int holidayId) {
		log.info("HolidayController :: deleteHolidayById function is started");
		try 
		{	
			log.info("deleteHolidayById function is started");
			this.holidayserv.deleteHolidayById(holidayId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Holiday is deleted !!!", true), HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			log.error("HolidayController :: Error in deleteTaskById "+e.getMessage());
			return null;
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Holiday>> getAllHoliday() {
		log.info("HolidayController :: getAllHoliday function is started");
		try
		{
			List<Holiday> allHoliday = this.holidayserv.getAllHoliday();
			return new ResponseEntity<List<Holiday>>(allHoliday, HttpStatus.ACCEPTED);			
		}
		catch(Exception e)
		{
			log.error("HolidayController :: Error in getAllHoliday "+e.getMessage());
			return null;
		}
	}

	@GetMapping("/getOne/{holidayId}")
	public ResponseEntity<Holiday> getOneHoliday(@PathVariable int holidayId) {
		log.info("HolidayController :: getOneHoliday function is started");
		try 
		{
			Holiday oneHoliday = this.holidayserv.getOneHoliday(holidayId);
			return new ResponseEntity<>(oneHoliday, HttpStatus.ACCEPTED);		
		}
		catch(Exception e)
		{
			log.error("HolidayController :: Error in getOneHoliday "+e.getMessage());
			return null;
		}
	}

	@PatchMapping("/{holidayId}")
	public ResponseEntity<Holiday> updateHoliday(@PathVariable int holidayId, @RequestBody Holiday holiday) {
		log.info("HolidayController :: updateHoliday function is started");
		try 
		{
			Holiday updateHoliday = this.holidayserv.updateHoliday(holidayId, holiday);
			return new ResponseEntity<>(updateHoliday, HttpStatus.ACCEPTED);			
		}
		catch(Exception e)
		{
			log.error("HolidayController :: Error in updateHoliday "+e.getMessage());
			return null;
		}
	}
}
