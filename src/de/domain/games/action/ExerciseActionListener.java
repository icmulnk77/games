package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import de.domain.games.model.ExerciseModel;


public class ExerciseActionListener implements ActionListener {
	
	private static JTextArea activeTextArea = null; 	
	private static String activeAccessPath = null;
	private static List<String> seriesList = null;
	
	public ExerciseActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
		seriesList = new ArrayList<String>();
	}
	
  public void actionPerformed(ActionEvent event) {
   	activeTextArea.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
  	seriesList = ExerciseModel.getSeriesList(activeAccessPath);
  	ExerciseModel.processSeries(activeAccessPath);
  	for (String series : seriesList) {
  		activeTextArea.append(series + "\n");
  	}
  }
}
