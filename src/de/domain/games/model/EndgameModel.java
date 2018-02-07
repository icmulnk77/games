package de.domain.games.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EndgameModel {

	private static List <String> games = null;
	private static List <String> endgameList = null;
	private static List <String> variationList = null;
	private static List <String> systemsList = null;
	
	private static final String PORTABLE_GAME_NOTATION = ".pgn";
	
	public static List<String> getEndgameList(String endgamePath) {
		endgameList = new ArrayList<String>();
		endgameList = GameModel.getDirectories(endgamePath);
    return endgameList;
	}
	
	public static void processEndgames(String colourPath) {

		// Iterating over all endgames 
		for (String endgame : endgameList) {
			String endgamePath = colourPath + File.separator + endgame;
			String targetPath = endgamePath + PORTABLE_GAME_NOTATION;
			System.out.println(endgamePath);
			System.out.println(targetPath);
			
			GameWriter.init(targetPath);
			GameWriter.delete();
			variationList = GameModel.getVariations(endgamePath);
			games = new ArrayList<String>();
			games = GameModel.getGames(variationList, games);
				
			// Writing all games in target base 
			for (String game : games) {
				GameWriter.write(game);
			}
			GameWriter.close();
		}		
	}
}
