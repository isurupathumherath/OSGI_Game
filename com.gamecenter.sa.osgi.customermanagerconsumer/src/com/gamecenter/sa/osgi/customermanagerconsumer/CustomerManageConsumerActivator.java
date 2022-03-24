package com.gamecenter.sa.osgi.customermanagerconsumer;

import com.gamecenter.sa.osgi.gamecustomerservice.GameCustomerManageService;
import com.gamecenter.sa.osgi.modelCustomer.Customer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CustomerManageConsumerActivator implements BundleActivator {

	ServiceReference gameCustomerManagerConsumerReference;
	Scanner scanner = new Scanner(System.in);
	Scanner optionScanner = new Scanner(System.in);
	boolean exit = false;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Customer Manager Consumer Started.============");
		gameCustomerManagerConsumerReference = bundleContext.getServiceReference(GameCustomerManageService.class.getName());
		GameCustomerManageService gameCustomerManageService = (GameCustomerManageService)bundleContext.getService(gameCustomerManagerConsumerReference);

		do {
			int option = -1;
			
			String customerName, customerAddress, customerNIC, customerMobileNumber, customerEmail, updatedName, updatedAddress, updatedNIC, updatedMobileNumber, updatedEmail;
			
			optionScanner.nextLine();
			
			System.out.println("\n...Options to be Selected...\n");
			System.out.println("1.Add New Customer");
			System.out.println("2.Update a Customer");
			System.out.println("3.Delete a Customer");
			System.out.println("4.Customer List");
			System.out.println("5.Search Customer");
			System.out.println("0.Exit");
			
			System.out.print("\nPlease Select: ");
			option = scanner.nextInt();
			
			if(option == 0)
				exit = true;
			else if(option == 1) {
				
				System.out.print("Customer Name: ");
				customerName = optionScanner.nextLine();
				
				System.out.print("Customer Address: ");
				customerAddress = optionScanner.nextLine();
				
				System.out.print("Customer NIC: ");
				customerNIC = optionScanner.nextLine();
				
				System.out.print("Customer Mobile Number: ");
				customerMobileNumber = optionScanner.nextLine();
				
				System.out.print("Customer Email Address: ");
				customerEmail = optionScanner.nextLine();
				
				String message = gameCustomerManageService.addCustomer(customerName, customerAddress, customerNIC, customerMobileNumber, customerEmail);
				if(message == null) {
					System.out.println("Customer cannot be added");
				} else {
					System.out.println(message);
				}
			}
			else if(option == 2) {

				System.out.print("Customer Name need to be updated: ");
				customerName = optionScanner.nextLine();
				
				System.out.print("New Customer Name: ");
				updatedName = optionScanner.nextLine();
				
				System.out.print("New Customer Address: ");
				updatedAddress = optionScanner.nextLine();
				
				System.out.print("New Customer NIC: ");
				updatedNIC = optionScanner.nextLine();
				
				System.out.print("New Customer Mobile Number: ");
				updatedMobileNumber = optionScanner.nextLine();
				
				System.out.print("New Customer Email Address: ");
				updatedEmail = optionScanner.nextLine();
				
				String message = gameCustomerManageService.updateCustomer(customerName, updatedName, updatedAddress, updatedNIC, updatedMobileNumber, updatedNIC);
				if(message == null) {
					System.out.println("Customer cannot be updated");
				} else {
					System.out.println(message);
				}
			}
			else if(option == 3) {
				
				System.out.print("Customer Name need to be deleted: ");
				customerName = optionScanner.nextLine();
				
				String message = gameCustomerManageService.removeCustomer(customerName);
				System.out.println(message);
			}
			else if(option == 4) {
				List<Customer> customerList =gameCustomerManageService.listCustomer();
				System.out.println("--------------------------------------------------Customer List-----------------------------------------------------------");
				System.out.println("Customer ID|"+"\t" + "Customer Name|" + "\t" + "Customer Address|" + "\t" + "Customer NIC|" + "\t" + "Customer Mobile No|" + "\t" + "Customer Email|" + "\t");
				for(Customer cus : customerList)  
					  System.out.println(cus.getCustomerId()+"\t\t"+cus.getCustomerName()+"\t\t"+cus.getCustomerAddress()+"\t\t"+cus.getCustomerNIC()+"\t\t"+cus.getCustomerMobileNumber()+"\t\t"+cus.getCustomerEmail()+"\t\t");  
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			}
			else if(option == 5) {
			
				System.out.println("Customer Name need to be Searched: ");
				customerName = optionScanner.nextLine();
				
				Customer game = gameCustomerManageService.searchCustomer(customerName);
				if(game != null) {
					System.out.println("Customer ID: " + game.getCustomerId());
					System.out.println("Customer Name: " + game.getCustomerName());
					System.out.println("Customer Address: " + game.getCustomerAddress());
					System.out.println("Customer NIC: " + game.getCustomerNIC());
					System.out.println("Customer Mobile Number: " + game.getCustomerMobileNumber());
					System.out.println("Customer Email Address: " + game.getCustomerEmail());
				}
				else {
					System.out.println("Customer is not found");
				}
			}
		}
		while(!exit);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Customer Manager Consumer Started.============");
		bundleContext.ungetService(gameCustomerManagerConsumerReference);
	}

}
