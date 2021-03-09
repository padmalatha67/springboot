package com.zemoso.springboot.springbootassignment;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootAssignmentApplication {

	private static final Logger LOGGER = LogManager.getLogger(SpringbootAssignmentApplication.class);

	public static void main(String[] args) {
		LOGGER.info("starting of application");
		SpringApplication.run(SpringbootAssignmentApplication.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
