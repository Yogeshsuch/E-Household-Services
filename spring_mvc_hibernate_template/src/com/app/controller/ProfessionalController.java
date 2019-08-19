package com.app.controller;

import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.app.pojos.Professional;
import com.app.pojos.Skill;
import com.app.service.IProfessionalService;

import Helpers.ProfPoxy;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@Controller
@RequestMapping("/professional")
public class ProfessionalController {
	
	@Autowired
	private IProfessionalService service;

	public ProfessionalController() {
		System.out.println("in cnstr " + getClass().getName());
	}
	

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(
			@RequestParam String name,
			@RequestParam String password, 
			@RequestParam String email,
			@RequestParam String mobileNo, 
			@RequestParam String address,
			@RequestParam String zip, 
			@RequestParam String locality, 
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String skill,
			@RequestParam MultipartFile file){
		
		System.out.println("in add professional " + name);
		Professional p = new Professional(name, email, password, mobileNo, address, zip, locality, city, state, skill);
		try {
			p.setDocument(file.getBytes());
			service.registerProfessional(p);
			return new ResponseEntity<String>("Professional added", HttpStatus.OK);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginProfessional(@RequestBody ProfPoxy p, HttpSession hs) throws URISyntaxException{
		System.out.println("in add customer " + p);
		try {
			Professional validCustomer = service.loginProfessional(p.getEmail(), p.getPassword());
			hs.setAttribute("valid_customer", validCustomer);
			System.out.println("From session "+validCustomer);
			return new ResponseEntity<String>(""+validCustomer.getPid(), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<String>("invalid "+e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/skill")
	public ResponseEntity<List<Skill>> getSkill(){
		System.out.println("in get skill ");
		try {
			return new ResponseEntity<List<Skill>>(service.getSkills(), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return null;
		}
		
	}
	
	@GetMapping("getDetails/{id}")
	public ResponseEntity<Professional> getDetails(@PathVariable int id){
		System.out.println("in get details ");
		Professional p = service.getDetails(id);
		System.out.println(p);
		return new ResponseEntity<Professional>(p, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Professional>> getCustomerList() {
		System.out.println("in get list");
		List<Professional> plist = service.getProfessionalList();
//		System.out.println(plist);
		return new ResponseEntity<List<Professional>>(plist, HttpStatus.OK);
	}
	
	@GetMapping("verify/{id}")
	public ResponseEntity<String> verifyProfessional(@PathVariable int id)
	{
		System.out.println("in verify pro "+id);
		return new ResponseEntity<String>(service.verifyProfessional(id),HttpStatus.OK);
	}
	
}
