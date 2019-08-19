package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.pojos.Orders;

import Helpers.AcceptedOrder;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao dao;

	public OrderServiceImpl() {
		System.out.println("Inside order service");
	}
	
	@Override
	public String bookOrder(int cid, Orders o) {
		return dao.bookOrder(cid,o);
	}

	@Override
	public List<Orders> orders(int cid) {
		System.out.println("inside order service");
		return dao.orders(cid);
	}

	@Override
	public List<Orders> getNewOrders(String skill) {
		// TODO Auto-generated method stub
		return dao.getNewOrders(skill);
	}

	@Override
	public String acceptOrder(int oid, int pid) {
		return dao.acceptOrder(oid,pid);
	}

	@Override
	public List<AcceptedOrder> acceptedOrders(int pid) {
		
		return dao.acceptedOrders(pid);
	}

	@Override
	public String orderCompleted(int oid) {
		
		return dao.orderCompleted(oid);
	}

	@Override
	public String cancelOrder(int oid) {
		return dao.cancelOrder(oid);
	}

}
