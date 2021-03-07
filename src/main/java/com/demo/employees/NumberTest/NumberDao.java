package com.demo.employees.NumberTest;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface NumberDao {

	
	public void update(int num);
	public List <Number> find();
	
}
