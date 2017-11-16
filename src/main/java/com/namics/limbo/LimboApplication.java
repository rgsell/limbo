package com.namics.limbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LimboApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LimboApplication.class, args);
	}
}
