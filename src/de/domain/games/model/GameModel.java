package de.domain.games.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The class GameModel represents the game 	 
 * @author Tim
 *
 */
public class GameModel {
	public static final String CHESSBASE_PORTABLE_GAME_NOTATION = "^(.*)\\.cbpgn$";
	public static final String CHESSBASE_OPENING_KEY = "^(.*)\\.cko$";
	public static final String CHESSBASE_OPENING_PROGRAM = "^(.*)\\.cpo$";
	public static final String INITIALIZATION = "^(.*)\\.ini$";
	public static final String PORTABLE_GAME_INFORMATION = "^(.*)\\.pgi$";
	public static final String PORTABLE_GAME_NOTATION = "^(.*)\\.pgn$";
	public static final String MAIN_VARIATION = "^00(.*)$";
		
	// Deleting all files with given signature 
	public static void deleteFiles(String accessPath) {
		File directory = new File(accessPath);
		String[] files =  directory.list();
		
		for (String file : files) {
			String activeDirectory = accessPath + File.separator + file;
			
			// Key patterns
			if (file.matches(CHESSBASE_PORTABLE_GAME_NOTATION) || 
					file.matches(CHESSBASE_OPENING_KEY) ||
					file.matches(CHESSBASE_OPENING_PROGRAM) ||
					file.matches(PORTABLE_GAME_INFORMATION)|| 
					file.matches(INITIALIZATION))	{	
				File deletedFile = new File(activeDirectory);
				deletedFile.delete();
			}
			
			// Check if the delete routine has reached the bottom 
			// If not then the routine should delete the generated pgn files 
			// and calls itself recursively
			File activeFile = new File(activeDirectory);			
			if (activeFile.isDirectory()) { 						// no
				for (String generatedFile : files) {
					if (generatedFile.matches(PORTABLE_GAME_NOTATION))	{
						String generatedFilePath = accessPath + File.separator + generatedFile;
						File generatedFileToDelete = new File(generatedFilePath);
						generatedFileToDelete.delete();
					}			
				}	
				deleteFiles(activeDirectory);							// run the routine recursively
			}	
		}
	}
	
	// Getting directories to a given super directory path
	public static List<String> getDirectories(String accessPath) {
		List<String> subDirectories = new ArrayList<String>();
		File directory = new File(accessPath);
		String[] directories = directory.list(); 
			for (String directoryCandidate : directories) {
				String filePath = accessPath + File.separator + directoryCandidate;
				File file = new File(filePath);
				if (file.isDirectory()) subDirectories.add(directoryCandidate);
			}
		return subDirectories;
	}
	
	// Getting all games to a variation
	public static List<String> getGames(List<String> variationList, List<String> games) {
		for (String variationPath : variationList) {
			GameReader.init(variationPath);
			String game = GameReader.getFirstGame();
			games.add(game);
		}
		return games;
	}
	
	// Getting variations to a given opening path 
	public static List<String> getVariations(String systemPath) {
		List <String> variationList = new ArrayList<String>();
		File system = new File(systemPath);
		String[] variations = system.list();
		for (String variationCandidate : variations ) {
			if (variationCandidate.matches(PORTABLE_GAME_NOTATION) &&
					!(variationCandidate.matches(MAIN_VARIATION))) {
				String variationPath = systemPath + File.separator + variationCandidate;	
				variationList.add(variationPath);
			}
		}
		return variationList;
	}	
	
	/**
	 * The method getMainVariations gathers the main variations of a given opening
	 * @param String openingPath 
	 */
	public static List<String> getMainVariations(String systemPath) {
		List <String> mainVariationList = new ArrayList<String>();
		File system = new File(systemPath);
		String[] mainVariations = system.list();
		for (String mainVariationCandidate : mainVariations ) {
			if (mainVariationCandidate.matches(PORTABLE_GAME_NOTATION) && 
					mainVariationCandidate.matches(MAIN_VARIATION)) {
				String mainVariationPath = systemPath + File.separator + mainVariationCandidate;	
				mainVariationList.add(mainVariationPath);
			}
		}
		return mainVariationList;
	}
	
}
