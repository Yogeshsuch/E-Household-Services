package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IZipCodeDao;
import com.app.pojos.ZipCode;

@Service
@Transactional
public class ZipCodeServiceImpl implements IZipCodeService {

	@Autowired
	IZipCodeDao dao;
	
	@Override
	public ZipCode getZip(String zip) {
	
		return dao.getZip(zip);
	}

}
