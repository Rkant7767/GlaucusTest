package com.demo.employees.NumberTest;

import java.util.List;

import org.springframework.stereotype.Component;

public interface NumberService {

	List<Number> find();
	void update(int num);
}
