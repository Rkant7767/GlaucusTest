package com.demo.employees.NumberTest;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class NumberDaoImpl implements NumberDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * The method update takes the number as input and checks if there is any number already available in the database if yes then it updates the value otherwise it inserts the value.
	 * @param num value of the variable"value" passed from the controller
	 */
	@Override
	public void update(int num) {
		
		List<Number> list=find(); 
		if(list.size()>0) {
			Number  number= list.get(0);
			number.setNumber(num);
			sessionFactory.getCurrentSession().save(number);
		}
		else {
			Number number= new Number();
			number.setNumber(1);
			sessionFactory.getCurrentSession().save(number);
		}
		
		
	}
	/*
	 * The method is used to get all the values present  in the database. Since the method update method is run as a scheduled insert or update task there would be only one column created
	 */
	@Override
	public List<Number> find() {
		TypedQuery<Number> query = sessionFactory.getCurrentSession().createQuery("from Number");
		return query.getResultList();
	}

	
	
}
