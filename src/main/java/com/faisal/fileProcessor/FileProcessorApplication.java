package com.faisal.fileProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileProcessorApplication {
	private static Logger LOG = LoggerFactory.getLogger(FileProcessorApplication.class);

	public static void main(String[] args) {
		LOG.debug("Starting application");
		SpringApplication.run(FileProcessorApplication.class, args);
		LOG.debug("Stopping application");
	}

}
