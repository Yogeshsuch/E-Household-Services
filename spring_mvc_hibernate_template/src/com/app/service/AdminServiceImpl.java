package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Feedback;
import com.app.pojos.Skill;

import Helpers.AcceptedOrder;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;
	
	public AdminServiceImpl() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@Override
	public String validateAdmin(String email, String password) {
		return dao.validateAdmin(email, password);
	}

	@Override
	public String addService(Skill s) {
		return dao.addService(s);
	}

	@Override
	public List<Feedback> getFeedbackList() {
		return dao.getFeedbackList();
	}

	@Override
	public List<AcceptedOrder> orders() {
		return dao.orders();
	}

}
