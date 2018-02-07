package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import de.domain.games.model.OpeningModel;

public class WhiteActionListener implements ActionListener {
	
	private static JTextArea activeTextArea = null; 	
	private static String activeAccessPath = null;
	private static List<String> openingList = null;
	
	public WhiteActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
		openingList = new ArrayList<String>();
	}
	
  public void actionPerformed(ActionEvent event) {
  	activeTextArea.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
  	openingList = OpeningModel.getOpeningList(activeAccessPath);
  	OpeningModel.processOpenings(activeAccessPath);
  	for (String opening : openingList) {
  		//  		System.out.println(opening);
  		activeTextArea.append(opening + "\n");
  	}
  }
}
