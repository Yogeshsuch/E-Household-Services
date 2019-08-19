package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Feedback;
import com.app.pojos.Skill;
import com.app.service.IAdminService;

import Helpers.AcceptedOrder;
import Helpers.CustomerProxy;
import Helpers.OrderProxy;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	public AdminController() {
		System.out.println("in cnstr " + getClass().getName());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody CustomerProxy pc) {
		System.out.println("in process login form admin " + pc.getEmail() + " " + pc.getPassword());
		try {
				return new ResponseEntity<String>(service.validateAdmin(pc.getEmail(), pc.getPassword()), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("login failed", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/addService")
	public ResponseEntity<String> addService(@RequestBody Skill s){
		System.out.println("in add service " + s);
		try {	
			return new ResponseEntity<String>(service.addService(s), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("Skill addition failed "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/feedbackList")
	public ResponseEntity<List<Feedback>> getFeedbackList() {
		System.out.println("in get list");
		List<Feedback> flist = service.getFeedbackList();
		System.out.println(flist);
		return new ResponseEntity<List<Feedback>>(flist, HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<AcceptedOrder> > acceptedOrders(){
		
		List<AcceptedOrder>  orderList = service.orders();
		System.out.println(orderList);

		return new ResponseEntity<List<AcceptedOrder>>(orderList, HttpStatus.OK);
	}
	
}
