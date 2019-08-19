package com.app.dao;
import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Professional;
import com.app.pojos.Skill;


@Repository
public class ProfessionalDaoImpl implements IProfessionalDao {

	@Autowired
	private SessionFactory sf;
	
	public ProfessionalDaoImpl() {
		
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public String registerProfessional(Professional p) {
		System.out.println("Inside prof dao"+p);
		sf.getCurrentSession().save(p);
		return "Successful";
	}

	@Override
	public List<Skill> getSkill() {
	
		String jpql = "select s from Skill s";
		return sf.getCurrentSession().createQuery(jpql, Skill.class).getResultList();
	}

	@Override
	public Professional loginProfessional(String email, String password) {
		String jpql = "select p from Professional p where p.email=:email AND p.password=:password AND p.verificationStatus=true";
		Professional validCustomer = sf.getCurrentSession().createQuery(jpql, Professional.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		
		return validCustomer;
	}
	
	@Override
	public List<Professional> getProfessionalList() {
		String jpql = "select p from Professional p";
		return sf.getCurrentSession().createQuery(jpql, Professional.class).getResultList();
	}

	@Override
	public Professional getDetails(int id) {
		String jpql = "select p from Professional p where p.pid=:id";
		return sf.getCurrentSession().createQuery(jpql,Professional.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public String verifyProfessional(int id) {
		
		System.out.println("Inside verify dao "+id);
		Professional p = sf.getCurrentSession().get(Professional.class, id);
		p.setVerificationStatus(true);
		return "success";
	}

	
}
