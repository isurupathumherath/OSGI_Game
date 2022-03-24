package com.gamecenter.sa.osgi.modelCustomer;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerNIC;
	private String customerMobileNumber;
	private String customerEmail;
	private int customerOrderCount;
	
	public Customer(int customerId, String customerName, String customerAddress, String customerNIC,
			String customerMobileNumber, String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerNIC = customerNIC;
		this.customerMobileNumber = customerMobileNumber;
		this.customerEmail = customerEmail;
		this.customerOrderCount = 0;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerNIC() {
		return customerNIC;
	}
	
	public void setCustomerNIC(String customerNIC) {
		this.customerNIC = customerNIC;
	}
	
	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}
	
	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public int getCustomerOrderCount() {
		return customerOrderCount;
	}
	
	public void setCustomerOrderCount(int customerOrderCount) {
		this.customerOrderCount = customerOrderCount;
	}
	
	
	
	
}
