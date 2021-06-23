package com.test.jdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.jdbctemplate.services.JDBCServices;

@RestController
public class TestController {
	
	@Autowired
	JDBCServices jdbcServices;
	
	@GetMapping("/division")
	public List<String> getDivisions() {
		return jdbcServices.getDivisions();
	}

}
