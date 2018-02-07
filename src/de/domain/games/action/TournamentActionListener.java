package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;

import de.domain.games.model.OpeningModel;
import de.domain.games.model.TournamentModel;

public class TournamentActionListener implements ActionListener {

	private static JTextArea activeTextArea = null;
	private static String activeAccessPath = null;
	private static final String EMPTY_STRING = "";
	private static List<String> yearList = null;

	public TournamentActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
	}

	public void actionPerformed(ActionEvent event) {
		activeTextArea.setText(EMPTY_STRING);
		activeTextArea
				.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
		yearList = TournamentModel.getYearList(activeAccessPath);
		TournamentModel.processYears(activeAccessPath);
		for (String year : yearList) {
			activeTextArea
					.append("Erzeuge Turnierdatenbank  " + year + "...\n");
		}
		TournamentModel.completeYears(activeAccessPath);
	}
}