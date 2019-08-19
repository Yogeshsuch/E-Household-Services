package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Feedback;
import com.app.pojos.Skill;

import Helpers.AcceptedOrder;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	
	public AdminDaoImpl() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@Override
	public String validateAdmin(String email, String password) {
		String jpql = "select a from Admin a where a.email=:email and a.password=:password";
		Admin a = sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		
		if(a != null) {
			return ""+a.getAid();
		}
		return "invalid";
	}

	@Override
	public String addService(Skill s) {
		sf.getCurrentSession().save(s);
		return "Successful";
	}

	@Override
	public List<Feedback> getFeedbackList() {
		String jpql = "select f from Feedback f";
		return sf.getCurrentSession().createQuery(jpql, Feedback.class).getResultList();
	}

	@Override
	public List<AcceptedOrder> orders() {
		
		String sql = "select o.oid, o.issue, o.expect_date,o.expect_time, o.address, o.status, o.amount, c.name, c.mobile_no, c.locality, c.zip from  Orders o inner join Customer_Info c on c.cid = o.cid";
//		String jpql = "select p.orderList from Professional where p.pid = pid";
//		List<Professional> p  = sf.getCurrentSession().createQuery(jpql, Professional.class).setParameter("pid", Professional.class).getResultList();
		List<AcceptedOrder> orderList =  sf.getCurrentSession().createSQLQuery(sql).getResultList();
		System.out.println("Inside order Dao" + orderList);

		
		return orderList;
	}

}
