package com.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.log.config.FileReaderService;

/**
 * 
 * This is the main class, which will be run as java application.
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		FileReaderService fileReaderService = ctx.getBean(FileReaderService.class);
		fileReaderService.readFile();
	}
}
