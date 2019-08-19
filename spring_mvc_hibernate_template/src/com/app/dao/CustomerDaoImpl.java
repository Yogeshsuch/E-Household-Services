package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Feedback;

import Helpers.CustomerProxy;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	private SessionFactory sf;
	
	public CustomerDaoImpl() {
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public List<Customer> getCustomerList() {
		String jpql = "select c from Customer c";
		return sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
	}
	
	@Override
	public String deleteCustomer(int id) {
		
		System.out.println("Inside customer "+ id);
		Customer c = sf.getCurrentSession().get(Customer.class, id);
		if (c != null) {
			sf.getCurrentSession().delete(c);
			return "Customer with ID " + id + " deleted";
		} else 
			return "Customer deletion failed";
	}
	
	@Override
	public String registerCustomer(Customer c) {
		sf.getCurrentSession().save(c);
		return "Successful";
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		String jpql = "select c from Customer c where c.email=:email AND c.password=:password";
		Customer validCustomer = sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		
		return validCustomer;
		
	}

	@Override
	public Customer getDetails(int id) {
		String jpql = "select c from Customer c where c.cid=:id";
		return sf.getCurrentSession().createQuery(jpql,Customer.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public String submitFeedback(Feedback f) {
		sf.getCurrentSession().save(f);
		return "Successful";
	}
	
	@Override
	public String updateUser(Customer c) {
		sf.getCurrentSession().update(c);
		return "success";
	}

}
