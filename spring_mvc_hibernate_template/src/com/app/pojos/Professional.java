package com.app.pojos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Freelancer_Info")
public class Professional {
	private Integer pid;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@NotEmpty
	private String mobileNo;
	private String address;
	@NotEmpty
	private String zip;
	@NotEmpty
	private String city;
	@NotEmpty
	private String locality;
	@NotEmpty
	private String state;
	private String skill;
	private boolean verificationStatus;
	@JsonBackReference
	private List<Orders> orderList;
	
	private byte[] document;
	
	public Professional() {
		System.out.println("in constr of "+getClass().getName());
	}

	public Professional(String name, String email, String password, String mobileNo, String address, String zip,
			String city, String locality, String state, String skill) {
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
		this.skill = skill;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	@OneToMany(mappedBy="professional", cascade=CascadeType.ALL)
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public boolean isVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	@Lob
	@Column(name="image_file")
	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}
	
	public void addProfessional(Orders o)
	{
		orderList.add(o);
		o.setProfessional(this);
	}
	

	@Override
	public String toString() {
		return "Professional [pid=" + pid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", zip=" + zip + ", city=" + city + ", locality="
				+ locality + ", state=" + state + ", skill=" + skill + ", verificationStatus=" + verificationStatus
				+ ", document=" + Arrays.toString(document) + "]";
	}
}
