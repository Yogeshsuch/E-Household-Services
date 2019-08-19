package com.app.dao;

import com.app.pojos.Customer;
import com.app.pojos.Feedback;

import Helpers.CustomerProxy;

public interface ICustomerDao {

	String registerCustomer(Customer c);
	Customer loginCustomer(String email, String password);
	Customer getDetails(int id);
	java.util.List<Customer> getCustomerList();
	String deleteCustomer(int id);
	String submitFeedback(Feedback f);
	String updateUser(Customer c);
}
