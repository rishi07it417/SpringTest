package com.integration.TestSpringIngeration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.integration.TestSpringIngeration.model.Employee;
import com.integration.TestSpringIngeration.model.Manager;

@Service
public class EmployeeService {

	@ServiceActivator(inputChannel = "employee.channel")
	public void sendEmployeeMessage(Message<Employee> msg) {
		System.out.print("##########Employee message##########"+ msg.toString());
		
	}
	
	@ServiceActivator(inputChannel = "manager.channel")
	public void sendManagerMessage(Message<Manager> msg) {
		System.out.print("##########Manager message##########"+ msg.toString());
		
	}
}
