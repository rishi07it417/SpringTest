package com.test.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.demo.repository.entity.UniMaster;



/**
 * Created by Jiankun Han on 06/27/2019.
 */

@Repository
public interface UniMasterRepository extends JpaRepository <UniMaster, Long> {
	
	public List<UniMaster> findByCollege(String college);
	public List<UniMaster> findByCollegeOrStuId(String college,String stuId);
	
	@Query("Select s from UniMaster s where s.student=:student1")
	public List<UniMaster> getStudent(@Param("student1") String student);
	
	@Query(value="Select s.* from UNI_MASTER s where s.STU_ID=:stuid",nativeQuery = true)
	public List<UniMaster> getStuId(@Param("stuid") String stuId);
	
	@Modifying
	@Query("UPDATE  UniMaster SET college=:college where stuId=:stuid")
	public int updateStudent(@Param("college") String college,@Param("stuid") String stuId);
	
	public List<UniMaster> findByCollege(String college,org.springframework.data.domain.Pageable page);



}
