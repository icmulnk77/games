package de.domain.games.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookModel {

	private static List <String> games = null;
	private static List <String> bookList = null;
	private static List <String> gameList = null;
	private static List <String> chapterList = null;
	
	private static final String PORTABLE_GAME_NOTATION = ".pgn";
	
	private static final Logger ConsoleLogger = LogManager.getLogger("de.domain.games.logger.ConsoleLogger");
	
	
	public static List<String> getBookList(String accessPath) {
		bookList = new ArrayList<String>();
		bookList = GameModel.getDirectories(accessPath);
    return bookList;
	}
		
	public static void processBook(String accessPath) {

		// Iterating over all books
		for (String book : bookList) {
			String bookPath = accessPath + File.separator + book;
			chapterList = new ArrayList<String>();
			chapterList = GameModel.getDirectories(bookPath);
		  ConsoleLogger.trace("Book:   " + book);
			
			// Iterating over all chapters of the actual book
			for (String chapter : chapterList) {
				ConsoleLogger.trace("Chapter: " + chapter);
				games = new ArrayList<String>();
				
				String chapterPath = bookPath + File.separator + chapter;
				String targetPath = chapterPath + PORTABLE_GAME_NOTATION;
				
				GameWriter.init(targetPath);
				GameWriter.delete();
				
				gameList = new ArrayList<String>();
				gameList = GameModel.getVariations(chapterPath);
				games = new ArrayList<String>();
				games = GameModel.getGames(gameList, games);

				int i = 0;
				// Writing all games in target base 
				for (String game : games) {				
					i++;
					ConsoleLogger.trace("Writing game:  " + i);
 					GameWriter.write(game);
				}
				GameWriter.close();
			}
			
		}
	}
}
