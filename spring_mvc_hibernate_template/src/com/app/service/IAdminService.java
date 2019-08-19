package com.app.service;

import java.util.List;

import com.app.pojos.Feedback;
import com.app.pojos.Skill;

import Helpers.AcceptedOrder;

public interface IAdminService {

	String validateAdmin(String email, String password);

	String addService(Skill s);

	List<Feedback> getFeedbackList();

	List<AcceptedOrder> orders();

}
