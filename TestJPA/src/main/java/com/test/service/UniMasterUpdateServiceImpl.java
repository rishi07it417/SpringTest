package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.UniMaster;
import com.test.repository.UniMasterRepository;

@Service
@Transactional
public class UniMasterUpdateServiceImpl {
	
	@Autowired
	UniMasterRepository uniRepo;
	
	public long insertStudent(long id,String college,String student,String stuid){
		
		UniMaster uni = new UniMaster();
		
		uni.setId(id);
		uni.setCollege(college);
		uni.setStudent(student);
		uni.setStuId(stuid);
				
		return uniRepo.save(uni).getId();
		
	}
	
public long upateStudent(String college,String stuid){
						
		return uniRepo.updateStudent(college, stuid);
		
	}


}
