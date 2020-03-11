package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.constants.Constants;
import com.example.demo.exception.ServiceException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${emp.service.url}")
	private String host;
    
	@Value("${emp.service.url.getProducts}")
    private String basePath;
    
	@Autowired
	private EmployeeRepository employeeRepository;

	public void callService(List<Employee> serviceInput) throws ServiceException {
		//Call Service and store the result to DB
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(host)
                .path(basePath)
                .queryParam("queryByIds", serviceInput.stream().map(x -> x.getEname()).collect(Collectors.joining(",")));

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,String.class);
                //new ParameterizedTypeReference<Type>());
		
		insertEmployeeDetails(response.getBody().toString());
	}
	
	private void insertEmployeeDetails(String response) throws ServiceException {
		employeeRepository.save(response);
		//String uri = serverUrl + empid + "/deptDetails";

		/*HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>(Constants.PARAMETERS, httpHeaders);
		try {
			ResponseEntity<Department> response = restTemplate.exchange(uri, HttpMethod.POST, entity,
					new ParameterizedTypeReference<Department>() {
					});
			dept = response.getBody();
			// Loop through the API output

		} catch (ServiceException ex) {
			logger.error("Exception occurred in insertEmployeeDetails service method {}", ex);
		}

		// read JSON and load json
		ObjectMapper mapper = new ObjectMapper();
		String deptJsonString = null;
		try {
			deptJsonString = mapper.writeValueAsString(dept);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		/*TypeReference<Department> typeReference = new TypeReference<Department>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(deptJsonString);
		try {
			Department department = mapper.readValue(inputStream, typeReference);
			 employeeRepository.save(department);
			System.out.println("Users Saved!");
		} catch (IOException e) {
			System.out.println("Unable to save users: " + e.getMessage());
		}*/
	}

}
