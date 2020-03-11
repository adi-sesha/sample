package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ServiceException;
import com.example.demo.model.Employee;

public interface EmployeeService {

	//public void insertEmployeeDetails(String serviceOutput) throws ServiceException;	
	abstract void callService(List<Employee> serviceInput) throws ServiceException;	
}
