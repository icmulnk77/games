package de.domain.games.control.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.domain.games.control.Main;

public class MainTest {

	public static boolean EXPECTED_MAIN_RUN = false;
	public static String[] ARGS = null;
	public static String START_ARG = null;
	
	@Before
	public void prepare() {
		START_ARG = new String("");
		ARGS[0] = START_ARG;
		Main.main(ARGS);
	}
	
//	@Test
//	public void testRun() {
//		EXPECTED_MAIN_RUN = Main.run();
//		assertTrue(EXPECTED_MAIN_RUN);
//	}

}
