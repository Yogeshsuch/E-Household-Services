package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Feedback;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao dao;
	
	public CustomerServiceImpl() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@Override
	public String registerCustomer(Customer c) {
		return dao.registerCustomer(c);
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		return dao.loginCustomer(email,password);
	}

	@Override
	public Customer getDetails(int id) {
		return dao.getDetails(id);
	}
	
	@Override
	public String deleteCustomer(int id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public List<Customer> getCustomerList() {
		return dao.getCustomerList();
	}
	
	@Override
	public String submitFeedback(Feedback f) {
		return dao.submitFeedback(f);
	}
	@Override
	public String updateUser(Customer c) {
		return dao.updateUser(c);
	}
	
}
