package com.gamecenter.sa.osgi.managerconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamecenter.sa.osgi.gamemanageservice.GameManageService;
import com.gamecenter.sa.osgi.model.Game;

public class ManagerConsumerActivator implements BundleActivator {

	ServiceReference gameManagerServiceReference;
	Scanner scanner = new Scanner(System.in);
	Scanner optionScanner = new Scanner(System.in);
	boolean exit = false;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Manager Consumer Started.============");
		gameManagerServiceReference = bundleContext.getServiceReference(GameManageService.class.getName());
		GameManageService gameManageService = (GameManageService)bundleContext.getService(gameManagerServiceReference);
		
		do {
			int option = -1;
			
			String gameName, gameProvider, gameYear, updateGameName, updateGameProvider, updateGameYear;
			double gamePrice, updateGamePrice;
			
			optionScanner.nextLine();
			
			System.out.println("\n...Options to be Selected...\n");
			System.out.println("1.Add New Game");
			System.out.println("2.Update a Game");
			System.out.println("3.Delete a Game");
			System.out.println("4.Game List");
			System.out.println("5.Search Games");
			System.out.println("0.Exit");
			
			System.out.print("\nPlease Select: ");
			option = scanner.nextInt();
			
			if(option == 0)
				exit = true;
			else if(option == 1) {
				//Get Game Name
				System.out.print("Game Name: ");
				gameName = optionScanner.nextLine();
				
				//Get Game Provider
				System.out.print("Game Provider: ");
				gameProvider = optionScanner.nextLine();
				
				//Get Game Year
				System.out.print("Game Year: ");
				gameYear = optionScanner.nextLine();
				
				//Get Game Price
				System.out.print("Game Price: ");
				gamePrice = optionScanner.nextDouble();
				
				String message = gameManageService.addGame(gameName, gameProvider, gameYear, gamePrice);
				if(message == null) {
					System.out.println("Game cannot be added");
				} else {
					System.out.println(message);
				}
			}
			else if(option == 2) {
				//Get Game Name
				System.out.print("Game Name need to be updated: ");
				gameName = optionScanner.nextLine();
				
				//Get Updating Name
				System.out.print("New Game Name: ");
				updateGameName = optionScanner.nextLine();
				
				//Get Updating Game Provider
				System.out.print("New Game Provider: ");
				updateGameProvider = optionScanner.nextLine();
				
				//Get Updating Game Year
				System.out.print("New Game Year: ");
				updateGameYear = optionScanner.nextLine();
				
				//Get Updating Game Price
				System.out.print("New Game Price: ");
				updateGamePrice = optionScanner.nextDouble();
				
				String message = gameManageService.updateGame(gameName, updateGameName, updateGameProvider, updateGameYear, updateGamePrice);
				if(message == null) {
					System.out.println("Game cannot be updated");
				} else {
					System.out.println(message);
				}
			}
			else if(option == 3) {
				//Get Game Name
				System.out.print("Game Name need to be deleted: ");
				gameName = optionScanner.nextLine();
				
				String message = gameManageService.removeGame(gameName);
				if(message == null) {
					System.out.println("Game cannot be removed");
				} else {
					System.out.println(message);
				}
			}
			else if(option == 4) {
				List<Game> gameList =gameManageService.listGame();
				System.out.println("-----------------------------------Game List--------------------------------------------");
				System.out.println("Game ID|"+"\t" + "Game Name|" + "\t\t" + "Game Provider|" + "\t\t\t" + "Game Year|" + "\t" + "Game Price|" + "\t\t");
				for(Game game : gameList)  
					  System.out.println(game.getGameId()+"\t\t"+game.getGameName()+"\t\t"+game.getGameProvider()+"\t\t"+game.getGameYear()+"\t\t"+game.getGamePrice()+"\t\t");  
				System.out.println("-----------------------------------------------------------------------------------------");
			}
			else if(option == 5) {
			
				System.out.println("Game Name need to be Searched: ");
				gameName = optionScanner.nextLine();
				
				Game game = gameManageService.searchGame(gameName);
				if(game != null) {
					System.out.println("Game ID: " + game.getGameId());
					System.out.println("Game Name: " + game.getGameName());
					System.out.println("Game Provider: " + game.getGameProvider());
					System.out.println("Game Price: " + game.getGamePrice());
				}
				else {
					System.out.println("Game is not found");
				}
			}
		}
		while(!exit);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Game Center Manager Consumer Stopped.============");
		bundleContext.ungetService(gameManagerServiceReference);
	}

}
