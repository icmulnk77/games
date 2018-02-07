package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.domain.games.model.OpeningModel;

public class BlackActionListener implements ActionListener {

	//Parameter to control the workflow of the application
	private static final Logger FileLogger = LogManager.getLogger("de.domain.games.logger.FileLogger");
	private static final Logger ConsoleLogger = LogManager.getLogger("de.domain.games.logger.ConsoleLogger");
	
	
	private static JTextArea activeTextArea = null; 	
	private static String activeAccessPath = null;
	private static List<String> openingList = null;
	
	public BlackActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
		openingList = new ArrayList<String>();
	}
	
  public void actionPerformed(ActionEvent event) {
  	activeTextArea.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
  	ConsoleLogger.trace("BlackActionListener actionPerformed...");
  	openingList = OpeningModel.getOpeningList(activeAccessPath);
  	OpeningModel.processOpenings(activeAccessPath);
  	for (String opening : openingList) {
  		activeTextArea.append(opening + "\n");
    	ConsoleLogger.trace("BlackActionListener actionPerformed opening:  " + opening);		
  	}
  }
}
