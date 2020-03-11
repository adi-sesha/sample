package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.DemoApplication;
import com.example.demo.constants.Constants;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
//@Validated
@Slf4j
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empServiceImpl;

	@PostMapping(value = "/employees}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmployeeDetails() {
		log.info("inside insertEmployeeDetails");
		
		int upto = 5;
		Long maxId = 0L;
		
		while (maxId != Constants.MAXID)
		{
			//Read values from DB TODO. Ca
			
			//Store details in list object
			List<Employee> lists = new ArrayList<Employee>();
			
			//Call service which takes care of internally calling service and store details into DB
			empServiceImpl.callService(lists);
			maxId = lists.stream()
					.mapToLong(x -> x.getId())
					.max().orElseThrow(NoSuchElementException::new);
		}
	}

//		return Arrays.asList(emp1, emp2, emp3);

}
