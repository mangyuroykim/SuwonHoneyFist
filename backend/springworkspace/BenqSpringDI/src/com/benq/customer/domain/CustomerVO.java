package com.benq.customer.domain;

public class CustomerVO {
	private String customerId;
	private String customerName;
	private String email;
	private String address;
	
	public CustomerVO() {}
	
	public CustomerVO(String customerId, String customerName, String email, String address) {
	    super();
	    this.customerId = customerId;
	    this.customerName = customerName;
	    this.email = email;
	    this.address = address;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "CustomerVo [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", address=" + address + "]";
	}


	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
