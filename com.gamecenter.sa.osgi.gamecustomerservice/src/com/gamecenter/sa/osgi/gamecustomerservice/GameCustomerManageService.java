package com.gamecenter.sa.osgi.gamecustomerservice;

import java.util.List;

import com.gamecenter.sa.osgi.modelCustomer.Customer;

public interface GameCustomerManageService {
	
	public String addCustomer(String name, String address, String nic, String mobileNumber, String email);
	public String updateCustomer(String name, String updateName, String updateAddress, String updateNIC, String updateMobileNumber, String updateEmail);
	public String removeCustomer(String name);
	public Customer searchCustomer(String name);
	public List<Customer> listCustomer();

}
