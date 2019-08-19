package com.app.service;

import java.util.List;

import com.app.pojos.Orders;

import Helpers.AcceptedOrder;

public interface IOrderService {

	String bookOrder(int cid,Orders o);

	public List<Orders> orders(int cid);

	List<Orders> getNewOrders(String skill);

	String acceptOrder(int oid,int pid);

	List<AcceptedOrder> acceptedOrders(int pid);

	String orderCompleted(int oid);

	String cancelOrder(int oid);

}
