package Helpers;

public class OrderProxy {
	
	private Integer oid;
	private String expectTime;
	private String expectDate;
	private String issue;
	private String address;
	private String mobileNo;
	private String service;
	private Integer cid;
	private Integer pid;
	
	public OrderProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getPid() {
		return pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Integer getOid() {
		return oid;
	}
	
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	public Integer getCid() {
		return cid;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getExpectTime() {
		return expectTime;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	@Override
	public String toString() {
		return "OrderProxy [oid=" + oid + ", expectTime=" + expectTime + ", expectDate=" + expectDate + ", issue="
				+ issue + ", address=" + address + ", mobileNo=" + mobileNo + ", service=" + service + ", cid=" + cid
				+ ", pid=" + pid + "]";
	}

	
	
	
}
