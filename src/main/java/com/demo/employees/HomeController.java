package com.demo.employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.employees.NumberTest.NumberService;
import com.demo.employees.NumberTest.NumberServiceImpl;

@Controller
public class HomeController {

	@Autowired
	 NumberService numberService;
	
	public static Integer value= 0;
	public static Integer lastEntry=0;
	/*
	 * Just a dummy method to print something on the first page.
	 */
	@RequestMapping(value="/")
	@CrossOrigin
	public ResponseEntity<Map<String,Object>> hello(@RequestParam(required=false, defaultValue="World") String name) {
		List list=new ArrayList();
		Map <String,Object> map= new HashMap<String,Object>();
		map.put("data", list);
		map.put("status","true");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	/*
	 * This method just increments the value of the static variable "value" 
	 * and returns hello in response
	 */
	@RequestMapping(value="/test")
	public synchronized @ResponseBody String test (){
				value++;
				return "hello";
	}
	
	/*
	 * This method runs every 2 seconds and checks if the last value is the same as the current value if yes then it neglects it else it saves the value of the variable in the number table
	 */
	@Scheduled(fixedRate = 2000)
	public void run() {
		
		if(lastEntry!=value) {
			//System.out.print("exec");
			numberService.update(value);
			lastEntry=value;
		}
		
	}
	
}
