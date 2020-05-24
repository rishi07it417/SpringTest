package com.test.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.repository.UniMasterRepository;
import com.test.demo.repository.entity.UniMaster;




@Service
@Transactional(readOnly = true)
public class UniMasterServiceImpl {
	
	@Autowired
	UniMasterRepository uniRepo;
	
	public List<UniMaster> getAvailableRec(){
				
		return uniRepo.findAll();
		
	}
	
	public Optional<UniMaster> getRecById(long id){
		
		return uniRepo.findById(id);
		
	}
	
	public List<UniMaster> getRecByCollege(String college){
		
		return uniRepo.findByCollege(college);
		
	}
	
	public List<UniMaster> getRecByCollegeOrStuId(String college,String input){
		
		return uniRepo.findByCollegeOrStuId(college,input);
		
	}
	
	public List<UniMaster> getStudent(String student){
		
		return uniRepo.getStudent(student);
		
	}
	
public List<UniMaster> getStuid(String stuid){
		
		return uniRepo.getStuId(stuid);
		
	}

public List<UniMaster> getRecByCollegePagwise(String college,PageRequest page){
	
	return uniRepo.findByCollege(college, page);
	
}
	

}
