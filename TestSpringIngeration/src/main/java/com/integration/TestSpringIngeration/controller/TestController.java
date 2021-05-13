package com.integration.TestSpringIngeration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TestSpringIngeration.gateway.MessageGateway;
import com.integration.TestSpringIngeration.model.Employee;
import com.integration.TestSpringIngeration.model.Manager;

@RestController
public class TestController {

	@Autowired
	MessageGateway msgGate;
	
	@PostMapping("/Employee")
	public void getEmployee(@RequestBody Employee emp) {
		 msgGate.process(emp);
	}
	
	@PostMapping("/Manager")
	public void getEmployee(@RequestBody Manager mng) {
		 msgGate.process(mng);
	}
}
