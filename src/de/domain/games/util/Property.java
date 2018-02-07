package de.domain.games.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is the property class of the application. It loads the properties, sets
 * its keys and returns for each key the current property
 * 
 * @author Tim Schmitz
 * @version 1.0
 */
public class Property {

	// Static variables to access the properties
	private static String directory = null;
	private static File file = null;
	private static Properties properties = null;

	// Static strings to access the properties settings
	private static String application = null;
	private static String archive = null;
	private static String base = null;
	private static String black = null;
	private static String book = null;
	private static String endgame = null;
	private static String exercise = null;
	private static String tournament = null;
	private static String white = null;

	/**
	 * The getBase method determines the value of the base property and returns
	 * it
	 * 
	 * @return applicationValue
	 */
	public static String getApplication() {
		String applicationValue = properties.getProperty(application);
		return applicationValue;
	}

	/**
	 * The getArchive method determines the value of the archive property and
	 * returns it
	 * 
	 * @return archiveValue
	 */
	public static String getArchive() {
		String archiveValue = properties.getProperty(archive);
		return archiveValue;
	}

	/**
	 * The getBase method determines the value of the base property and returns
	 * it
	 * 
	 * @return baseValue
	 */
	public static String getBase() {
		String baseValue = properties.getProperty(base);
		return baseValue;
	}

	/**
	 * The getBlack method determines the value of the black property and
	 * returns it
	 * 
	 * @return blackValue
	 */
	public static String getBlack() {
		String blackValue = properties.getProperty(black);
		return blackValue;
	}

	/**
	 * The getBook method determines the value of the book property and returns
	 * it
	 * 
	 * @return bookValue
	 */
	public static String getBook() {
		String bookValue = properties.getProperty(book);
		return bookValue;
	}

	/**
	 * The getEndgame method determines the value of the endgame property and
	 * returns it
	 * 
	 * @return endgameValue
	 */
	public static String getEndgame() {
		String endgameValue = properties.getProperty(endgame);
		return endgameValue;
	}

	/**
	 * The getExercise method determines the value of the exercise property and
	 * returns it
	 * 
	 * @return exerciseValue
	 */
	public static String getExercise() {
		String exerciseValue = properties.getProperty(exercise);
		return exerciseValue;
	}

	/**
	 * The getTournament method determines the value of the tournament property
	 * and returns it
	 * 
	 * @return tournamentValue
	 */
	public static String getTournament() {
		String tournamentValue = properties.getProperty(tournament);
		return tournamentValue;
	}

	/**
	 * The getWhite method determines the value of the white property and
	 * returns it
	 * 
	 * @return whiteValue
	 */
	public static String getWhite() {
		String whiteValue = properties.getProperty(white);
		return whiteValue;
	}

	/**
	 * The load method creates an input stream with the given file name and
	 * loads the properties of the project
	 */
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream(file);
			properties.load(inputStream);
		} catch (IOException ioException) {
			ioException.getMessage();
		}
	}

	/**
	 * The setKey method sets for each property the keys to get the value later
	 */
	public static void setKeys() {
		application = new String("application");
		archive = new String("archive");
		base = new String("base");
		black = new String("black");
		book = new String("book");
		endgame = new String("endgame");
		exercise = new String("exercise");
		tournament = new String("tournament");
		white = new String("white");
	}

	/**
	 * The setProperties method sets the directory and the file for the
	 * properties of the project by given path and filename. It calls the
	 * setKeys method directly
	 */
	public static void setProperties() {
		directory = System.getProperty("user.dir") + File.separator
				+ new String("properties");
		file = new File(directory, "games.properties");
		properties = new Properties();
		setKeys();
	}

}
