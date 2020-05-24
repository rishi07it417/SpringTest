package com.test.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jiankun Han on 06/27/2019.
 */

@Entity
@Table(name = "UNI_MASTER")
public class UniMaster {
	
	@Id
	@Column(name = "ID")
    private Long id;
	
	@Column(name = "COLLEGE")
    private String college;
	
	@Column(name = "STUDENT")
    private String student;
	
	@Column(name = "STU_ID")
    private String stuId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}


	@Override
	public String toString() {
		return "UniMaster [id=" + id + ", college=" + college + ", student="
				+ student + ", stuId=" + stuId + "]";
	}
	
	
}

