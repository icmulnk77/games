package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import de.domain.games.model.Archivar;

public class ArchiveActionListener implements ActionListener {
	
	private static JTextArea activeTextArea = null; 	
	private static String activeAccessPath = null;
	private static final String EMPTY_STRING = "";
	
	public ArchiveActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
	}
	
  public void actionPerformed(ActionEvent event) {
  	activeTextArea.setText(EMPTY_STRING);
  	activeTextArea.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
  	Archivar.process();
  }
}