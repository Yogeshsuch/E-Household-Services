package Helpers;

import org.hibernate.validator.constraints.NotEmpty;

public class AcceptedOrder {
	
	private Integer oid;
	private String expectTime;
	private String expectDate;
	private String issue;
	private double amount;
	private String paymentRemark;
	private String status;
	private String address;
	private String cMobileNo;
	private String zip;
	private String city;
	private String locality;
	private String email;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getExpectTime() {
		return expectTime;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}
	public String getExpectDate() {
		return expectDate;
	}
	public void setExpectDate(String expectDate) {
		this.expectDate = expectDate;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentRemark() {
		return paymentRemark;
	}
	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getcMobileNo() {
		return cMobileNo;
	}
	public void setcMobileNo(String cMobileNo) {
		this.cMobileNo = cMobileNo;
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
	@Override
	public String toString() {
		return "FinalOrder [oid=" + oid + ", expectTime=" + expectTime + ", expectDate=" + expectDate + ", issue="
				+ issue + ", amount=" + amount + ", paymentRemark=" + paymentRemark + ", status=" + status
				+ ", address=" + address + ", cMobileNo=" + cMobileNo + ", zip=" + zip + ", city=" + city
				+ ", locality=" + locality + "]";
	}

	
	
}
