package com.gamecenter.sa.osgi.gamemanageservice;

import java.util.List;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.model.Game;

public class GameManageServiceImpl implements GameManageService{

	@Override
	public String addGame(String gameName, String gameProvider, String gameYear, Double gamePrice) {
		int itemCount = DataStore.gameList.size();
		Game game = new Game(itemCount + 1, gameName, gameProvider, gameYear, gamePrice);
		DataStore.gameList.add(game);
		return gameName + " is added under game id " + (itemCount + 1);
	}

	@Override
	public synchronized String updateGame(String gameName, String updateGameName, String updateGameProvider, String updateGameYear, Double updateGamePrice) {
		Game gameUpdate = null;
		boolean value = false;
		int count = -1;
		for(Game game : DataStore.gameList) {
			count ++;
			if(game.getGameName().equals(gameName)) {
				gameUpdate = game;
				value = true;
				break;
			}
		}
		if(value) {
			gameUpdate.setGameName(updateGameName);
			gameUpdate.setGameProvider(updateGameProvider);
			gameUpdate.setGameYear(updateGameYear);
			gameUpdate.setGamePrice(updateGamePrice);
			
			DataStore.gameList.set(count, gameUpdate);
		}
		return "Game " + gameName + " is updated successfully";
	}

	@Override
	public synchronized String removeGame(String gameName) {
		int count = -1;
		for(Game game : DataStore.gameList) {
			count ++;
			if(game.getGameName().equals(gameName)) {
				DataStore.gameList.remove(count);
				break;
			}
		}
		return "Game " + gameName + " is removed successfully";
	}

	@Override
	public Game searchGame(String gameName) {
		Game searchedResult = null;
		boolean value = false;
		for(Game game : DataStore.gameList) {
			if(game.getGameName().equals(gameName)) {
				searchedResult = game;
				value = true;
				break;
			}
		}
		return searchedResult;
	}

	@Override
	public List<Game> listGame() {
		return DataStore.gameList;
	}

}
