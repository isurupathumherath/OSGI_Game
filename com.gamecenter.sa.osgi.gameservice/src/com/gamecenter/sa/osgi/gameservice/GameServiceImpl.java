package com.gamecenter.sa.osgi.gameservice;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.model.Game;

public class GameServiceImpl implements GameService{
	
	private List<Game> itemList = DataStore.gameList;
	private HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();

	@Override
	public List<Game> displayGame() {
		return DataStore.gameList;
	}
	
	@Override
	public String addToCart(String gameName, int quantity) {
		int count = -1;
		boolean value = false;
		for(Game game : DataStore.gameList) {
			count ++;
			if(game.getGameName().equals(gameName)) {
				cart.put(game.getGameId(), quantity);
				value = true;
				break;
			}
		}
		
		if(value)
			return "Item cannot be found. Please try again!";
		else
			return "Item is added to cart successfully";
	}
	
	@Override
	public HashMap<Integer, Integer> displayCart() {
		return cart;
	}

	@Override
	public double displayBillTotal() {
		HashMap<Integer, Integer> cartMap = displayCart();
		List<Game> gameList = itemList;
		double total = 0;
		
		for (Integer i : cartMap.keySet()) {
			for(Game game : gameList) {
				if(game.getGameId() == i) {
					total += game.getGamePrice() * cartMap.get(i);
					break;
				}
			}
		}
		return total;
	}

	@Override
	public String removeFromCart(String gameName) {
		int count = -1;
		boolean value = false;
		for(Game game : DataStore.gameList) {
			count ++;
			if(game.getGameName().equals(gameName)) {
				cart.remove(game.getGameId());
				value = true;
				break;
			}
		}
		
		if(value)
			return "Item cannot be found. Please try again!";
		else
			return "Item is removed from cart successfully";
	}
}
