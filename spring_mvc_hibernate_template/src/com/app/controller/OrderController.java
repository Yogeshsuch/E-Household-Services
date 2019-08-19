package com.app.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Customer;
import com.app.pojos.Orders;

import com.app.service.IOrderService;

import Helpers.AcceptedOrder;
import Helpers.OrderProxy;
import Helpers.ProfPoxy;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService service;
	@Autowired
	private JavaMailSender sender;
	
	private String emailText = "Once order is confirm we will send confirmation mail,Thank you, For using HomeKhaas...!";
	
	public OrderController() {
		System.out.println("Inside order controller");
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> orderPlaced(@RequestBody  OrderProxy o, HttpSession hs){
		System.out.println("in add customer " + o);
			
		try {
			int cid = o.getCid();
			java.util.Date date = new java.util.Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String d = format.format(date);
			
			Orders order = new Orders(o.getExpectTime(), o.getExpectDate(), d, o.getIssue(), 150.0, "Pending", "New", o.getAddress(), o.getMobileNo(), o.getService());
			Customer validCustomer = (Customer)hs.getAttribute("valid_customer");
			System.out.println("From session in order "+validCustomer);
			String msg = service.bookOrder(cid,order);
			if(msg != null) {
				SimpleMailMessage mesg=new SimpleMailMessage();
				mesg.setTo(msg);
				mesg.setSubject("Your Order is placed");
				mesg.setText(this.emailText);
				sender.send(mesg);
			}
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Order addition failed ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("ordersDetails/{id}")
	public ResponseEntity<List<Orders>> getDetails(@PathVariable int id){
		System.out.println("in orders details ");
		List<Orders> orders = service.orders(id);
		System.out.println(orders);
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<List<Orders>> getNewOrders(@RequestBody ProfPoxy p){
		String skill = p.getSkill();
		System.out.println("inside orders" + skill);
		List<Orders> orders = service.getNewOrders(skill);
		System.out.println(orders);
		
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
	}
	
	@PostMapping("/accept")
	public ResponseEntity<String> acceptOrder(@RequestBody OrderProxy o){
		System.out.println("inside accept" + o);
		int oid = o.getOid();
		int pid = o.getPid();
		System.out.println("inside accept" + oid);
		String msg = service.acceptOrder(oid,pid);
		System.out.println(msg);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/acceptedOrders")
	public ResponseEntity<List<AcceptedOrder> > acceptedOrders(@RequestBody OrderProxy o){
		System.out.println("inside accept" + o);
		int pid = o.getPid();
		
		List<AcceptedOrder>  orderList = service.acceptedOrders(pid);
		System.out.println(orderList);

		return new ResponseEntity<List<AcceptedOrder>>(orderList, HttpStatus.OK);
	}
	
	@PostMapping("/orderComplete")
	public ResponseEntity<String> orderCompleted(@RequestBody OrderProxy o){
		System.out.println("inside accept" + o);
		int oid = o.getOid();
		System.out.println("inside accept" + oid);
		String msg = service.orderCompleted(oid);
		
		System.out.println(msg);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/cancelOrder")
	public ResponseEntity<String> cancelOrder(@RequestBody OrderProxy o){
		System.out.println("inside accept" + o);
		int oid = o.getOid();
		System.out.println("inside accept" + oid);
		String msg = service.cancelOrder(oid);
		System.out.println(msg);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
