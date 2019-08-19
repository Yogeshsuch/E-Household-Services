package com.app.pojos;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Zip_Code")
public class ZipCode {
	
	private String zip;
	@NotEmpty
	private String locality;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	
	public ZipCode() { 
		System.out.println("in cnstr " + getClass().getName());
	}

	@Id
	@Column(unique = true)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ZipCode [zip=" + zip + ", locality=" + locality + ", city=" + city + ", state=" + state + "]";
	}
	
}
