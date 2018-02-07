package de.domain.games.dialog.test;

import de.domain.games.dialog.Dialog;
import de.domain.games.util.Property;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Dialog class. It prepares the test and tests all 
 * testable methods of the Dialog class and is resetting the file system in the state as is
 * was before the test    
 * @author Tim Schmitz
 */
public class DialogTest {
	
	
	@Before
	public void prepare() {
		Property.setProperties();
		Property.load();
	}
	
	
	@Test
	public void test() {
		//		fail("Not yet implemented");
	}

}
