package com.app.pojos;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Orders")
public class Orders {
	
	private Integer oid;
	@NotEmpty
	private String expectTime;
	@NotEmpty
	private String expectDate;
	private String orderDate;
	@NotEmpty
	private String issue;
	private double amount;
	private String paymentRemark;
	private String status;
	private String address;
	private String mobileNo;
	private String service;
	@JsonManagedReference
	private Professional professional;
	@JsonManagedReference
	private Customer customer;
	
	public Orders() {
		System.out.println("Inside order pojo");
	}
	
	
	
	public Orders(String expectTime, String expectDate, String orderDate, String issue, double amount,
			String paymentRemark, String status, String address, String mobileNo, String service) {
		super();
		this.expectTime = expectTime;
		this.expectDate = expectDate;
		this.orderDate = orderDate;
		this.issue = issue;
		this.amount = amount;
		this.paymentRemark = paymentRemark;
		this.status = status;
		this.address = address;
		this.mobileNo = mobileNo;
		this.service = service;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOid() {
		return oid;
	}
	
	
	@ManyToOne()
	@JoinColumn(name="pid")
	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	@ManyToOne()
	@JoinColumn(name="cid")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name="expect_time")
	public String getExpectTime() {
		return expectTime;
	}
	
	public void setExpectTime(String expectTime) {
		System.out.println("set time");
		this.expectTime = expectTime;
	}

	@Column(name="expect_date")
	public String getExpectDate() {
		return expectDate;
	}

	public void setExpectDate(String expectDate) {
		this.expectDate = expectDate;
	}

	@Column(name="order_date")
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	@Column(name="payment_remark")
	public String getPaymentRemark() {
		return paymentRemark;
	}

	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}

	@Column(name="status")
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
	
	@Column(name="mobile_no")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", expectTime=" + expectTime + ", expectDate=" + expectDate + ", orderDate="
				+ orderDate + ", issue=" + issue + ", amount=" + amount + ", paymentRemark=" + paymentRemark
				+ ", status=" + status + ", address=" + address + ", mobileNo=" + mobileNo + ", service=" + service
				+ "]";
	}
	
	
	

}
