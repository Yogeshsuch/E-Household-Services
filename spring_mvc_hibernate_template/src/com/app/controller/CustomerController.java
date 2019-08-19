package com.app.controller;


import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.pojos.Customer;
import com.app.pojos.Feedback;
import com.app.service.ICustomerService;

import Helpers.CustomerProxy;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	
	public CustomerController() {
		System.out.println("in cnstr " + getClass().getName());
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerProxy cp){
		System.out.println("in add customer " + cp);
		Customer c = new Customer(cp.getName(), cp.getEmail(), cp.getPassword(), cp.getMobileNo(), cp.getAddress(), cp.getZip(), cp.getCity(), cp.getLocality(), cp.getState());
		try {
			return new ResponseEntity<String>(service.registerCustomer(c), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("Customer addition failed "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody CustomerProxy c, HttpSession hs) throws URISyntaxException{
		System.out.println("in add customer " + c);
		try {
			Customer validCustomer = service.loginCustomer(c.getEmail(), c.getPassword());
			hs.setAttribute("valid_customer", validCustomer);
			System.out.println("From session "+validCustomer);
			return new ResponseEntity<String>(""+validCustomer.getCid(), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("invalid "+e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("getDetails/{id}")
	public ResponseEntity<Customer> getDetails(@PathVariable int id){
		System.out.println("in get details ");
		Customer c = service.getDetails(id);
		System.out.println(c);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> getCustomerList() {
		System.out.println("in get list");
		List<Customer> clist = service.getCustomerList();
		System.out.println(clist);
		return new ResponseEntity<List<Customer>>(clist, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id)
	{
		System.out.println("in delete Customer "+id);
		return new ResponseEntity<String>(service.deleteCustomer(id),HttpStatus.OK);
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<String> submitFeedback(@RequestBody Feedback f){
		System.out.println("in add feedback " + f);
		try {	
			return new ResponseEntity<String>(service.submitFeedback(f), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("Feedback addition failed "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("update")
	public ResponseEntity<String> updateUser(@RequestBody CustomerProxy cp){
		Customer c = new Customer();
		c.setCid(cp.getCid());
		c.setAddress(cp.getAddress());
		c.setCity(cp.getCity());
		c.setEmail(cp.getEmail());
		c.setLocality(cp.getLocality());
		c.setMobileNo(cp.getMobileNo());
		c.setName(cp.getName());
		c.setPassword(cp.getPassword());
		c.setZip(cp.getZip());
		c.setState(cp.getState());
		System.out.println("in update details of customer "+c);
		return new ResponseEntity<String>(service.updateUser(c), HttpStatus.OK);
	}
		
	
}
