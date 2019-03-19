package com.practice.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create the query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		//execute query and get the result list
		List<Customer> customers = query.getResultList();
		
		//return results
		return customers;
	}

}
