package com.gamecenter.sa.osgi.gameservice;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.model.Game;

public interface GameService {
	public List<Game> displayGame();
	public String addToCart(String gameName, int quantity);
	public String removeFromCart(String gameName);
	public double displayBillTotal();
	public HashMap<Integer, Integer> displayCart();
}
