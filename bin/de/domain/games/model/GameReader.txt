package de.domain.games.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
// import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.input.BOMInputStream;

public class GameReader {
//	private static String base = null;
	private static String firstGame = null;				
	private static BufferedReader bufferedReader = null;	
	private static InputStreamReader bomInputStreamReader;
	private static final String EMPTY_LINE = "^\\s*$"; 	
	private static final String LINE_FEED = "\r\n"; 
	
	// Initializing a buffered reader
	public static void init(String variationPath) {
		bufferedReader = createBuffer(variationPath);
	}
	
	// Creating a buffer for input
	public static BufferedReader createBuffer(String filename) {
		BufferedReader input = null;
		try {
			 FileInputStream inputStream = new FileInputStream(filename);
			 bomInputStreamReader = new InputStreamReader(new BOMInputStream(inputStream));
			 input = new BufferedReader(bomInputStreamReader);
		} 
		catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}
		 return input;
	}

	// Getting first game of variation
	public static String getFirstGame() {
		boolean isFirstGame = true;
		int countEmptyLines = 0;
		
		// Try to read the pgn-File
		try {
			String inputLine = new String();
			firstGame = new String();
			
			// Iterate the lines of the file and put them into buffer
			while (!(inputLine = bufferedReader.readLine()).equals(null)) {				
		
				// line is empty
				if (Pattern.compile(EMPTY_LINE).matcher(inputLine).matches()) 
					countEmptyLines += 1;																					

				// line is text 
        if (isFirstGame) {																					
        	firstGame = firstGame + inputLine + LINE_FEED;						
      		if (countEmptyLines == 2) isFirstGame = false; 						 				
      	}              
			}
		}
		catch(IOException ioException) {
			System.err.println(ioException.getMessage());
		}
		catch(NullPointerException nullPointerException) {
      closeBuffer();
		}		
		return firstGame;
	}
	
	// Closing the buffer
	public static void closeBuffer() {
		try {
			bufferedReader.close();
		}
		catch(IOException ioException) {
			System.err.println(ioException.getMessage());
		}
	}
}
