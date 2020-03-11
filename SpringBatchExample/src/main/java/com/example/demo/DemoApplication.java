package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.EmployeeController;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@Slf4j

public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ConfigurableApplicationContext ctx;

	@Autowired
	private EmployeeController employeecontroller;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}