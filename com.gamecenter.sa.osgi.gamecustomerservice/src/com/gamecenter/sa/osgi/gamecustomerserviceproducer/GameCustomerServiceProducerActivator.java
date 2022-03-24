package com.gamecenter.sa.osgi.gamecustomerserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.gamecenter.sa.osgi.gamecustomerservice.GameCustomerManageService;
import com.gamecenter.sa.osgi.gamecustomerservice.GameCustomerManageServiceImpl;

public class GameCustomerServiceProducerActivator implements BundleActivator {

	ServiceRegistration serviceRegisterer;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Customer Manage Service Started.============");
		GameCustomerManageService gameCustomerManage = new GameCustomerManageServiceImpl();
		serviceRegisterer = bundleContext.registerService(GameCustomerManageService.class.getName(), gameCustomerManage, null); //Register Customer Manage Service
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Customer Manage Service Started.============");
		serviceRegisterer.unregister(); //Unregister from gameCustomerManage
	}

}
