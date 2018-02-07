package de.domain.games.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExerciseModel {

	private static List <String> positions = null;
	private static List <String> seriesList = null;
	private static List <String> issueList = null;
	private static List <String> exerciseList = null;
	
	private static final String PORTABLE_GAME_NOTATION = ".pgn";
	
	public static List<String> getSeriesList(String accessPath) {
		seriesList = new ArrayList<String>();
		seriesList = GameModel.getDirectories(accessPath);
    return seriesList;
	}
		
	public static void processSeries(String accessPath) {

		// Iterating over all openings of the given colour
		for (String series : seriesList) {
			String seriesPath = accessPath + File.separator + series;
			String targetPath = seriesPath + PORTABLE_GAME_NOTATION;
			GameWriter.init(targetPath);
			GameWriter.delete();
			exerciseList = new ArrayList<String>();
			exerciseList = GameModel.getDirectories(seriesPath);
		
			// Iterating over all systems of the actual opening
			for (String exercise : exerciseList) {
				positions = new ArrayList<String>();
				String exercisePath = seriesPath + File.separator + exercise;
				issueList = new ArrayList<String>();
				issueList = GameModel.getVariations(exercisePath);
				positions = new ArrayList<String>();
				positions = GameModel.getGames(issueList, positions);
				
				// Writing all positions in target base 
				for (String position : positions) {
					GameWriter.write(position);
				}
			}
			GameWriter.close();
		}
	}
}
