package de.domain.games.util.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.domain.games.util.Property;

/**
 * Test class for the Property class. It prepares the test and tests all 
 * testable methods of the Property class and is resetting the file system in the state as is
 * was before the test    
 * @author Tim Schmitz
 * @version 1.0
 */
public class PropertyTest {

	// Static variables for test
	public static String EXPECTED_APPLICATION_NAME = null;
	public static String EXPECTED_BASE_PATH = null;
	public static String EXPECTED_BLACK_PATH = null;
	public static String EXPECTED_BOOK_PATH = null; 
	public static String EXPECTED_ENDGAME_PATH = null;
	public static String EXPECTED_EXERCISE_PATH = null;
	public static String EXPECTED_MY_BLACK_PATH = null;
	public static String EXPECTED_MY_WHITE_PATH = null;
	public static String EXPECTED_TOURNAMENT_PATH = null;
	public static String EXPECTED_WHITE_PATH = null; 
	
	
	@Before
	public void prepare() {
		
		// Preparing the expected values
		EXPECTED_APPLICATION_NAME = new String("Partiefilter");
		EXPECTED_BASE_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase");
		EXPECTED_BLACK_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Eröffnung\\Schwarz");
		EXPECTED_BOOK_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Buch");
		EXPECTED_ENDGAME_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Endspiel");		
		EXPECTED_EXERCISE_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Übung");
		EXPECTED_MY_BLACK_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\TimEröffnung\\Schwarz");
		EXPECTED_MY_WHITE_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\TimEröffnung\\Wei�");	
		EXPECTED_TOURNAMENT_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Turnier");
		EXPECTED_WHITE_PATH = new String("C:\\Users\\Tim\\Documents\\ChessBase\\TimBase\\Eröffnung\\Weiß");
		
		// Setting and loading the properties
		Property.setProperties();
		Property.load();
	}
	
	@Test
	public void testGetApplication() {
		assertEquals(EXPECTED_APPLICATION_NAME,Property.getApplication());
	}
	
	@Test
	public void testGetBase() {
		assertEquals(EXPECTED_BASE_PATH,Property.getBase());
	}
	
	@Test
	public void testGetBlack() {
		assertEquals(EXPECTED_BLACK_PATH,Property.getBlack());
	}

	@Test
	public void testGetBook() {
		assertEquals(EXPECTED_BOOK_PATH,Property.getBook());
	}
	
	@Test
	public void testGetEndgame() {
		assertEquals(EXPECTED_ENDGAME_PATH,Property.getEndgame());
	}

	@Test
	public void testGetExercise() {
		assertEquals(EXPECTED_EXERCISE_PATH,Property.getExercise());
	}
	
	@Test
	public void testGetTournament() {
		assertEquals(EXPECTED_TOURNAMENT_PATH,Property.getTournament());
	}
	
	@Test
	public void testGetWhite() {
		assertEquals(EXPECTED_WHITE_PATH,Property.getWhite());
	}

		
}
