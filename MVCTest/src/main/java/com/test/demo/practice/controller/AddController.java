package com.test.demo.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.demo.repository.entity.UniMaster;
import com.test.demo.service.UniMasterServiceImpl;
import com.test.demo.service.UniMasterUpdateServiceImpl;


@Controller
public class AddController {
	
	@Autowired
	UniMasterServiceImpl uniMasterService;
	
	@Autowired
	UniMasterUpdateServiceImpl 	uniMasterUpdateService;
	
	@RequestMapping("add")
	public ModelAndView doAdd(@RequestParam("n1") int num1, @RequestParam("n2") int num2){
		
		//int result = num1+num2;
		
		List<UniMaster> result = uniMasterService.getAvailableRec();
		
		ModelAndView mv = new ModelAndView();
				
		mv.addObject("result", result);
		mv.setViewName("result.jsp");
		
		return mv;
		
	}
	
	/*@RequestMapping("findRecords")
	public ModelAndView findRec(){
		
		List<UniMaster> result = uniMasterService.getAvailableRec();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("result.jsp");
		
		return mv;
		
	}*/

}
