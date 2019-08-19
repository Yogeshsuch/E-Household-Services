package Helpers;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProfPoxy {
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private String address;
	private String zip;
	private String city;
	private String locality;
	private String state;
	private String skill;
	private MultipartFile file;
	
	public ProfPoxy() {
		// TODO Auto-generated constructor stub
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	
	}

	@Override
	public String toString() {
		return "ProfPoxy [name=" + name + ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", address=" + address + ", zip=" + zip + ", city=" + city + ", locality=" + locality + ", state="
				+ state + ", skill=" + skill + ", file=" + file + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getMobileNo()=" + getMobileNo()
				+ ", getAddress()=" + getAddress() + ", getZip()=" + getZip() + ", getCity()=" + getCity()
				+ ", getLocality()=" + getLocality() + ", getState()=" + getState() + ", getSkill()=" + getSkill()
				+ ", getFile()=" + getFile() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
