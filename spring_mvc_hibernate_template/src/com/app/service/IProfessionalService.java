package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.Professional;
import com.app.pojos.Skill;


public interface IProfessionalService {

	String registerProfessional(Professional p);

	List<Skill> getSkills();

	Professional loginProfessional(String email, String password);

	Professional getDetails(int id);

	List<Professional> getProfessionalList();
	String verifyProfessional(int id);

}
