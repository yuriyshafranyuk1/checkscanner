package com.checkscanner.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.checkscanner.check")
@EnableAutoConfiguration
@SpringBootApplication
public class CheckApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CheckApplication.class, args);
	}
}
