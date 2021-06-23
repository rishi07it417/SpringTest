package com.test.jdbctemplate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.test.jdbctemplate.utils.TestJDBCTemplateUtils;

@Service
public class JDBCServices {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public List<String> getDivisions() {
		SqlRowSet rs = jdbctemplate.queryForRowSet(TestJDBCTemplateUtils.GET_DIVISON);
		List<String> division = new ArrayList<String>();
		while(rs.next()){
			division.add(rs.getString("DIVISION"));
		}
				
		return division;
	}
	
}
