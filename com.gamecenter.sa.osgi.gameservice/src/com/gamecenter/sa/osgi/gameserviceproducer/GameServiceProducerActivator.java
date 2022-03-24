package com.gamecenter.sa.osgi.gameserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.gamecenter.sa.osgi.gamemanageservice.GameManageService;
import com.gamecenter.sa.osgi.gamemanageservice.GameManageServiceImpl;
import com.gamecenter.sa.osgi.gameservice.GameService;
import com.gamecenter.sa.osgi.gameservice.GameServiceImpl;

public class GameServiceProducerActivator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Service Started.============");
		GameService gameService = new GameServiceImpl();
		serviceRegisterer = bundleContext.registerService(GameService.class.getName(), gameService, null); //Register GameService
		GameManageService gameManageService = new GameManageServiceImpl();
		serviceRegisterer = bundleContext.registerService(GameManageService.class.getName(), gameManageService, null); //Register GameManagerService
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Service Stopped.=============");
		serviceRegisterer.unregister(); //Unregister from GameServiceProducter
	}

}
