package com.demo.employees.NumberTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl  implements NumberService{
	
	@Autowired
	NumberDao numberDaoImpl;
	public void update(int num) {
		numberDaoImpl.update(num);
	}
	
	public List<Number> find(){
		List<Number> list= numberDaoImpl.find();
		return list;
	}
}
