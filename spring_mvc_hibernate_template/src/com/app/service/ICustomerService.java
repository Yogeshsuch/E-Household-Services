package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.Feedback;

import Helpers.CustomerProxy;


public interface ICustomerService {

	public String registerCustomer(Customer c);
	public Customer loginCustomer(String email, String password);
	public Customer getDetails(int id);
	List<Customer> getCustomerList();
	public String deleteCustomer(int id);
	public String submitFeedback(Feedback f);
	public String updateUser(Customer c);
	
}
