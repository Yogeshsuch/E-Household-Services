package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Professional;

import Helpers.AcceptedOrder;
import Helpers.OrderProxy;

@Repository
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	SessionFactory sf;
	
	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String bookOrder(int cid,Orders o) {
		System.out.println("Inside order dao");
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.addCustomer(o);
		sf.getCurrentSession().save(o);
		String email = c.getEmail();
		return email;
	
	}

	@Override
	public List<Orders> orders(int cid) {
		System.out.println("inside order dao");
//		String jpql = "select o from Orders o where cid=:cid";
//		
//		List<Orders> orderList = sf.getCurrentSession().createQuery(jpql, Orders.class).setParameter("cid", cid).getResultList();
//		
		String sql = "select o.oid, o.service, o.issue, o.order_date, o.expect_date, o.status, o.amount, p.name, p.mobile_no from Orders o left join Freelancer_Info p on p.pid = o.pid where o.cid = "+cid;
		List<Orders> orderList = sf.getCurrentSession().createSQLQuery(sql).getResultList();
		return orderList;
	}

	@Override
	public List<Orders> getNewOrders(String skill) {
		String jpql = "select o from Orders o where o.service=:skill and o.status='New'";
		List<Orders> orderList = sf.getCurrentSession().createQuery(jpql, Orders.class).setParameter("skill", skill).getResultList();
		return orderList;
	}

	@Override
	public String acceptOrder(int oid, int pid) {
		Orders o = sf.getCurrentSession().get(Orders.class, oid);
		o.setStatus("Pending");
		Professional p = sf.getCurrentSession().get(Professional.class, pid);
		p.addProfessional(o);
		sf.getCurrentSession().update(o);
		return "Sucess";
	}

	//for professional profile
	@Override
	public List<AcceptedOrder> acceptedOrders(int pid) {
		String sql = "select o.oid, o.issue, o.expect_date,o.expect_time, o.address, o.status, o.amount, c.name, c.mobile_no, c.locality, c.zip from  Orders o inner join Customer_Info c on c.cid = o.cid where o.pid = "+pid;
//		String jpql = "select p.orderList from Professional where p.pid = pid";
//		List<Professional> p  = sf.getCurrentSession().createQuery(jpql, Professional.class).setParameter("pid", Professional.class).getResultList();
		List<AcceptedOrder> orderList =  sf.getCurrentSession().createSQLQuery(sql).getResultList();
		System.out.println("Inside order Dao" + orderList);

		return orderList;
	}

	@Override
	public String orderCompleted(int oid) {
		
		Orders o = sf.getCurrentSession().get(Orders.class, oid);
		o.setStatus("Completed");
		sf.getCurrentSession().save(o);
		return "Success";
	}

	@Override
	public String cancelOrder(int oid) {
		Orders o = new Orders();
		o.setOid(oid);
	//	Orders o = sf.getCurrentSession().get(Orders.class, oid);
		//System.out.println(o);
		
			sf.getCurrentSession().delete(o);
			return "success";
	}
}

