package com.gamecenter.sa.osgi.gamemanageservice;

import java.util.List;

import com.gamecenter.sa.osgi.model.Game;

public interface GameManageService {
	public String addGame(String gameName, String gameProvider, String gameYear, Double gamePrice);
	public String updateGame(String gameName, String updateGameName, String updateGameProvider, String updateGameYear, Double updateGamePrice);
	public String removeGame(String gameName);
	public Game searchGame(String gameName);
	public List<Game> listGame();
}