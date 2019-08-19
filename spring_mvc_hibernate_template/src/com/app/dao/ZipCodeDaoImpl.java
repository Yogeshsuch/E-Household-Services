package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.ZipCode;

@Repository
public class ZipCodeDaoImpl implements IZipCodeDao {

	/*
	 * @Override public ZipCode getZipCode(String zip) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String insertZipCode(ZipCode z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZipCode getZip(String zip) {

		String jpql = "select z from ZipCode z where z.zip=:zip";
		
		return sf.getCurrentSession().createQuery(jpql, ZipCode.class).setParameter("zip", zip).getSingleResult();
	}

}
