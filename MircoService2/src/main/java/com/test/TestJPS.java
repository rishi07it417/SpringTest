package com.test;

import java.util.List;
import java.util.Optional;

import org.h2.mvstore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.UniMaster;
import com.test.service.UniMasterServiceImpl;
import com.test.service.UniMasterUpdateServiceImpl;


/**
 * Created by Jiankun Han on 06/27/2019
 */

@SpringBootApplication
@EnableAutoConfiguration
public class TestJPS implements CommandLineRunner {

	@Autowired
	UniMasterServiceImpl uniMasterService;
	
	@Autowired
	UniMasterUpdateServiceImpl 	uniMasterUpdateService;
	
	public static void main(String[] args) {
		SpringApplication.run(TestJPS.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//getAllUniMasterRecords();
		//getRecById(1l);
		//getRecByCollegeOrId("1","07IT417");
		//getgStudent("RISHI");
		//getstuid("07EC533");
		
		//insertStudent(4,"GCET","ANKIT","07IT211");
		
		//updateStudent("GCET","07CE111");
		getRecByCollegePagwise("GCET");

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
