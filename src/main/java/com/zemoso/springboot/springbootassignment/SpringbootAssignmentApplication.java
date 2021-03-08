package com.zemoso.springboot.springbootassignment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootAssignmentApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootAssignmentApplication.class);

	public static void main(String[] args) {
		LOGGER.info("starting of application");
		SpringApplication.run(SpringbootAssignmentApplication.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
