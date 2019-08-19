package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProfessionalDao;
import com.app.pojos.Professional;
import com.app.pojos.Skill;

@Service
@Transactional
public class ProfessionalServiceImpl implements IProfessionalService {

	@Autowired
	private IProfessionalDao dao;
	
	public ProfessionalServiceImpl() {
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public String registerProfessional(Professional p) {
		System.out.println("inside prof reg");
		return dao.registerProfessional(p);
	}

	@Override
	public List<Skill> getSkills() {
	
		return dao.getSkill();
	}

	@Override
	public Professional loginProfessional(String email, String password) {
		
		return dao.loginProfessional(email, password);
	}

	@Override
	public Professional getDetails(int id) {
		return dao.getDetails(id);
	}
	@Override
	public List<Professional> getProfessionalList() {
		return dao.getProfessionalList();
	}

	@Override
	public String verifyProfessional(int id) {
		return dao.verifyProfessional(id);
	}
	
	
	

}
