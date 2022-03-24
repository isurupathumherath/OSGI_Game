package com.gamecenter.sa.osgi.model;

public class Game {
	
	private int gameId;
	private String gameName;
	private String gameProvider;
	private String gameYear;
	private double gamePrice;
	
	public Game(int gameId, String gameName, String gameProvider, String gameYear, double gamePrice) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameProvider = gameProvider;
		this.gameYear = gameYear;
		this.gamePrice = gamePrice;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameProvider() {
		return gameProvider;
	}
	public void setGameProvider(String gameProvider) {
		this.gameProvider = gameProvider;
	}
	public double getGamePrice() {
		return gamePrice;
	}
	public void setGamePrice(double gamePrice) {
		this.gamePrice = gamePrice;
	}
	public String getGameYear() {
		return gameYear;
	}
	public void setGameYear(String gameYear) {
		this.gameYear = gameYear;
	}
	
	
	

}
