package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.ZipCode;
import com.app.service.IZipCodeService;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@Controller
@RequestMapping("/zipCode")
public class ZipCodeController {
	@Autowired
	private IZipCodeService service;
	
	public ZipCodeController() {
		System.out.println("in cnstr " + getClass().getName());
	}
	
	@GetMapping("zip/{zip}")
	public ResponseEntity<?> getZip(@PathVariable String zip){
		System.out.println("in get zip ");
		try {
			return new ResponseEntity<ZipCode>(service.getZip(zip), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("Zip not found"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
