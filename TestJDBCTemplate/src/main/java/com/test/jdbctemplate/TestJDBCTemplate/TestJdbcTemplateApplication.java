package com.test.jdbctemplate.TestJDBCTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.test.jdbctemplate.controller,com.test.jdbctemplate.services")
@SpringBootApplication
public class TestJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJdbcTemplateApplication.class, args);
	}

}
