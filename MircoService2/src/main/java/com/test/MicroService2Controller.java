package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.test.entity.UniMaster;
import com.test.service.UniMasterServiceImpl;
import com.test.service.UniMasterUpdateServiceImpl;

@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class MicroService2Controller {
	
	@Autowired
	UniMasterServiceImpl uniMasterService;
	
	@Autowired
	UniMasterUpdateServiceImpl 	uniMasterUpdateService;

	@GetMapping("/MicroService2Controller")
	public Map<Integer,UniMaster> getAnswer(){
		
		RestTemplate resttm = new RestTemplate();
		Map<Integer,UniMaster> citymap = new HashMap<Integer,UniMaster>();

		UniMaster uni = resttm.getForObject("http://localhost:8081/unimaster", UniMaster.class);
		
		insertStudent(uni.getId(),uni.getCollege(),uni.getStudent(),uni.getStuId());
		
		citymap.put(1, uni);
		return citymap;
	}
	
public void getRecByCollegePagwise(String college){
		
		List<UniMaster> recs = uniMasterService.getRecByCollegePagwise(college,new PageRequest(1, 2, Direction.ASC, "id") );
		
		recs.forEach(r->System.out.println(r));
	}
	
public void updateStudent(String college,String stuid){
		
		long i= uniMasterUpdateService.upateStudent(college, stuid);
		
		System.out.println("Resutl::::::::"+i);
	}
	
public void insertStudent(long id,String college,String student,String stuid){
		
		long i= uniMasterUpdateService.insertStudent(id, college, student, stuid);
		
		System.out.println("Resutl::::::::"+i);
	}
	
public void getstuid(String stuid){
		
		List<UniMaster> recs = uniMasterService.getStuid(stuid);
		
		recs.forEach(r->System.out.println(r));
	}
	
	public void getgStudent(String student){
		
		List<UniMaster> recs = uniMasterService.getStudent(student);
		
		recs.forEach(r->System.out.println(r));
	}
	
	public void getRecByCollegeOrId(String college,String input){
		
		List<UniMaster> recs = uniMasterService.getRecByCollegeOrStuId(college,input);
		
		recs.forEach(r->System.out.println(r));
	}
	
	public void getRecByCollege(String college){
		
		List<UniMaster> recs = uniMasterService.getRecByCollege(college);
		
		recs.forEach(r->System.out.println(r));
	}
	public void getAllUniMasterRecords(){
		
		List<UniMaster> recs = uniMasterService.getAvailableRec();
		
		recs.forEach(r->System.out.println(r));
	}
	
		public void getRecById(long id){
		
			Optional<UniMaster> uni = uniMasterService.getRecById(id);
			
			if(uni.isPresent()){
				System.out.println(uni);
			}
	}


}
