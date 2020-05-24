package com.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.test.entity.UniMaster;

@EnableWebMvc
@RestController
public class MiscroService1Controller {

	@GetMapping("/MiscroService1Controller")
	public Map<String,String> getCities(@RequestParam("country") String country){
		
		Map<String,String> citymap = new HashMap<String,String>();
		if(country.toLowerCase().equals("india")){
			citymap.put("1", "Mumbai");
			citymap.put("2", "Chennai");
			citymap.put("3", "Delhi");
			citymap.put("4", "Kolkata");

		}else{
			citymap.put("1", "No Data Found");
		}
		
		return citymap;
	}
	
	@GetMapping("/unimaster")
	public UniMaster getCities(){
		
		UniMaster uni = new UniMaster();
		uni.setId(1l);
		uni.setCollege("BVM");
		uni.setStudent("student");
		uni.setStuId("417");
		
		
		return uni;
	}
}
