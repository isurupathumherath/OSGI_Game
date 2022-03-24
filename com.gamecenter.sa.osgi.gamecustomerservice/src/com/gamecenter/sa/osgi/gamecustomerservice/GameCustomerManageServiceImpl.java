package com.gamecenter.sa.osgi.gamecustomerservice;

import java.util.List;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.modelCustomer.Customer;

public class GameCustomerManageServiceImpl implements GameCustomerManageService{

	@Override
	public String addCustomer(String name, String address, String nic, String mobileNumber, String email) {
		int customerCount = DataStore.customerList.size();
		Customer customer = new Customer(customerCount + 1, name, address, nic, mobileNumber, email);
		DataStore.customerList.add(customer);
		return name + " is added under customer id " + (customerCount + 1);
	}

	@Override
	public synchronized String updateCustomer(String name, String updateName, String updateAddress, String updateNIC,
			String updateMobileNumber, String updateEmail) {
		Customer customerUpdate = null;
		boolean value = false;
		int count = -1;
		for(Customer cus : DataStore.customerList) {
			count ++;
			if(cus.getCustomerName().equals(name)) {
				customerUpdate = cus;
				value = true;
				break;
			}
		}
		if(value) {
			customerUpdate.setCustomerName(updateName);
			customerUpdate.setCustomerAddress(updateAddress);
			customerUpdate.setCustomerNIC(updateNIC);
			customerUpdate.setCustomerMobileNumber(updateMobileNumber);
			customerUpdate.setCustomerEmail(updateEmail);
			
			DataStore.customerList.set(count, customerUpdate);
			return "Customer " + name + " is updated successfully";
		}
		else 
			return "Customer " + name + " is not found";
		
	}

	@Override
	public synchronized String removeCustomer(String name) {
		int count = -1;
		boolean value = false;
		for(Customer cus : DataStore.customerList) {
			count ++;
			if(cus.getCustomerName().equals(name)) {
				DataStore.customerList.remove(count);
				value = true;
				break;
			}
		}
		if(value == true) 
			return "Customer " + name + " is removed successfully";
		else
			return "Customer Not Found! Please Try Again!";
	}

	@Override
	public Customer searchCustomer(String name) {
		Customer searchedResult = null;
		boolean value = false;
		for(Customer cus : DataStore.customerList) {
			if(cus.getCustomerName().equals(name)) {
				searchedResult = cus;
				value = true;
				break;
			}
		}
		return searchedResult;
	}

	@Override
	public List<Customer> listCustomer() {
		return DataStore.customerList;
	}

}
