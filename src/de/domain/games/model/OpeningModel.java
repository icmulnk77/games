package de.domain.games.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpeningModel {

	private static List <String> mainGames = null;
	private static List <String> games = null;
	private static List <String> openingList = null;
	private static List <String> mainVariationList = null;
	private static List <String> variationList = null;
	private static List <String> systemsList = null;
	private static final String PORTABLE_GAME_NOTATION = ".pgn";
	
	
	//Parameter to control the workflow of the application
	private static final Logger FileLogger = LogManager.getLogger("de.domain.games.logger.FileLogger");
	private static final Logger ConsoleLogger = LogManager.getLogger("de.domain.games.logger.ConsoleLogger");
		
	public static List<String> getOpeningList(String openingPath) {
		openingList = new ArrayList<String>();
		openingList = GameModel.getDirectories(openingPath);
    return openingList;
	}
		
	/**
	 * The processOpening processes all openings of the given color.
	 * Opening:			01 Sizilianische Verteidigung
	 * System:			0101 Najdorf-System
	 * Variation:	  01 Moderne Hauptvariante
	 * @param colourPath
	 */
	public static void processOpenings(String colourPath) {

		String colourOpeningPath =  colourPath + File.separator + PORTABLE_GAME_NOTATION;
    ConsoleLogger.trace("openingModel processOpenings colourOpeningPath: " + colourOpeningPath);
			
  	// Iterating over all openings of the given color
		for (String opening : openingList) {
			String openingPath = colourPath + File.separator + opening;
			String targetMainPath = openingPath + PORTABLE_GAME_NOTATION;
	    ConsoleLogger.trace("openingModel processOpenings targetMainPath: " + targetMainPath);
	    GameWriter.init(targetMainPath);
			GameWriter.delete();
		
			systemsList = new ArrayList<String>();
			systemsList = GameModel.getDirectories(openingPath);
		
			// Iterating over all systems of the actual opening
			for (String system : systemsList) {
				
				String systemPath = openingPath + File.separator + system;
				String targetPath = systemPath + PORTABLE_GAME_NOTATION;
				mainVariationList = new ArrayList<String>();
				mainVariationList = GameModel.getMainVariations(systemPath);
				mainGames = new ArrayList<String>();
				mainGames = GameModel.getGames(mainVariationList, mainGames);
				
				// Writing all main games in target base 	
				for (String mainGame : mainGames) {
					GameWriter.write(mainGame);
				}
			}
			GameWriter.close();			
			
			// Iterating over all systems of the actual opening
			for (String system : systemsList) {
				String systemPath = openingPath + File.separator + system;
				String targetPath = systemPath + PORTABLE_GAME_NOTATION;
						
				GameWriter.init(targetPath);
				GameWriter.delete();
						
				variationList = new ArrayList<String>();
				variationList = GameModel.getVariations(systemPath);
						
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
}
