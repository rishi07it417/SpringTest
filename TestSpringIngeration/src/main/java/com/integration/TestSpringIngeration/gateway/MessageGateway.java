package com.integration.TestSpringIngeration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.integration.TestSpringIngeration.model.Employee;

@MessagingGateway
public interface MessageGateway {

	@Gateway(requestChannel = "integration.router")
	public  <T> void process(T object);
	
}
