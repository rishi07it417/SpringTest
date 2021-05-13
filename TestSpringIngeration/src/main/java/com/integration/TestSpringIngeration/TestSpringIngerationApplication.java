package com.integration.TestSpringIngeration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;
import org.springframework.messaging.MessageChannel;

import com.integration.TestSpringIngeration.model.Employee;
import com.integration.TestSpringIngeration.model.Manager;


@Configuration
@EnableIntegration
@IntegrationComponentScan
@SpringBootApplication
public class TestSpringIngerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringIngerationApplication.class, args);
	}
	
	@Bean
	public MessageChannel recieverChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel replyChannel() {
		return new DirectChannel();
	}
	
	@Bean
	@ServiceActivator(inputChannel = "integration.router")
	public PayloadTypeRouter payloadTypeRouter() {
		PayloadTypeRouter pr = new PayloadTypeRouter();
		pr.setChannelMapping(Employee.class.getName(), "integration.router.toHeaderEnricherEmployee");
		pr.setChannelMapping(Manager.class.getName(), "integration.router.toHeaderEnricherManager");
		System.out.println("##########Inside PayloadTypeRouter#########"+pr.toString());
		return pr;
	}
	
	@Bean
	@Transformer(inputChannel = "integration.router.toHeaderEnricherEmployee", outputChannel = "integration.router.fromHeaderEnricher")
	public HeaderEnricher headerEnricherEmployee() {
		Map<String,HeaderValueMessageProcessor<String>> header = new HashMap<String,HeaderValueMessageProcessor<String>>();

		header.put("TestHeader", new StaticHeaderValueMessageProcessor<String>("employee"));
		HeaderEnricher he = new HeaderEnricher(header);
		System.out.println("##########Inside HeaderEnricher employee#########"+he.toString());
		return he;
	}
	
	@Bean
	@Transformer(inputChannel = "integration.router.toHeaderEnricherManager", outputChannel = "integration.router.fromHeaderEnricher")
	public HeaderEnricher headerEnricherManager() {
		Map<String,HeaderValueMessageProcessor<String>> header = new HashMap<String,HeaderValueMessageProcessor<String>>();

		header.put("TestHeader", new StaticHeaderValueMessageProcessor<String>("manager"));
		HeaderEnricher he = new HeaderEnricher(header);
		System.out.println("##########Inside HeaderEnricher manager#########"+he.toString());
		return he;
	}
	
	@Bean
	@ServiceActivator(inputChannel = "integration.router.fromHeaderEnricher")
	public HeaderValueRouter router() {
		HeaderValueRouter hr = new HeaderValueRouter("TestHeader");
		hr.setChannelMapping("employee", "employee.channel");
		hr.setChannelMapping("manager", "manager.channel");
		System.out.println("##########Inside Header Value Router#########"+hr.toString());
		return hr;
		
	}


}
