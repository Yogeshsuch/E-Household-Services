package com.app.pojos;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customer_Info")
public class Customer {
	
	private Integer cid;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	@NotEmpty
	@Length(min=10,max=10)
	private String mobileNo;
	@NotEmpty
	private String address;
	@NotEmpty
	private String zip;
	@NotEmpty
	private String city;
	@NotEmpty
	private String locality;
	@NotEmpty
	private String state;
	

	@JsonBackReference
	private List<Orders> orderList = new ArrayList<>();
	
	
	public Customer() {
		System.out.println("in cnstr " + getClass().getName());
	}
	
	public Customer(String name, String email, String password, String mobileNo, String address, String zip,
			String city, String locality, String state) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.locality = locality;
		this.state = state;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "mobile_no")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void addCustomer(Orders o)
	{
		orderList.add(o);
		o.setCustomer(this);
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileNo="
				+ mobileNo + ", address=" + address + ", zipCode=" + zip + ", city=" + city + ", locality="
				+ locality + ", state=" + state + "]";
	}
	
}
