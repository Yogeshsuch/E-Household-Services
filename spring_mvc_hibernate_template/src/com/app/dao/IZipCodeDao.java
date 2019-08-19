package com.app.dao;

import com.app.pojos.ZipCode;

public interface IZipCodeDao {
	//public ZipCode getZipCode(String zip);
	public String insertZipCode(ZipCode z);
	public ZipCode getZip(String zip);
}
