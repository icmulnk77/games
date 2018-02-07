package de.domain.games.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.domain.games.action.ArchiveActionListener;
import de.domain.games.action.BlackActionListener;
import de.domain.games.action.BookActionListener;
import de.domain.games.action.EmptyActionListener;
import de.domain.games.action.EndgameActionListener;
import de.domain.games.action.ExerciseActionListener;
import de.domain.games.action.TournamentActionListener;
import de.domain.games.action.WhiteActionListener;

public class Builder {

	private static GridBagConstraints gridBagConstraints = null;
	private static GridBagLayout gridBagLayout = null;

	private static JFrame dialogFrame = null;
	private static JPanel dialogPanel = null;
	private static JPanel displayPanel = null;
	private static JScrollPane scrollPane = null;
	private static Dimension dimension = null;
	private static JPanel controlPanel = null;
	private static JTextArea textArea = null;

	private static JButton buttonArchive = null;
	private static JButton buttonWhite = null;
	private static JButton buttonBlack = null;
	private static JButton buttonEmpty = null;
	private static JButton buttonEndgame = null;
	private static JButton buttonExercise = null;
	private static JButton buttonTournament = null;
	private static JButton buttonTraining = null;

	private static final String ARCHIVE = "^.*Archiv$";
	private static final String WHITE = "^.*Wei\\ß$";
	private static final String BLACK = "^.*Schwarz$";
	private static final String BASE = "^.*Base$";
	private static final String ENDGAME = "^.*Endspiel$";
	private static final String EXERCISE = "^.*\\Übung$";
	private static final String TOURNAMENT = "^.*Turnier$";
	private static final String BOOK = "^.*Buch$";

	private static ArchiveActionListener actionListenerArchive = null;
	private static WhiteActionListener actionListenerWhite = null;
	private static BlackActionListener actionListenerBlack = null;
	private static EmptyActionListener actionListenerEmpty = null;
	private static EndgameActionListener actionListenerEndgame = null;
	private static ExerciseActionListener actionListenerExercise = null;
	private static TournamentActionListener actionListenerTournament = null;
	private static BookActionListener actionListenerTraining = null;

	public static JButton activateButton(JTextArea textArea,
			String accessPath) {
		JButton activeButton = new JButton();

		// System.out.println(accessPath);

		if (accessPath.matches(ARCHIVE)) {
			actionListenerArchive = new ArchiveActionListener(textArea,
					accessPath);
			buttonArchive.addActionListener(actionListenerArchive);
			activeButton = buttonArchive;
		}

		if (accessPath.matches(WHITE)) {
			actionListenerWhite = new WhiteActionListener(textArea, accessPath);
			buttonWhite.addActionListener(actionListenerWhite);
			activeButton = buttonWhite;
		}
		if (accessPath.matches(BLACK)) {
			actionListenerBlack = new BlackActionListener(textArea, accessPath);
			buttonBlack.addActionListener(actionListenerBlack);
			activeButton = buttonBlack;
		}
		if (accessPath.matches(BASE)) {
			actionListenerEmpty = new EmptyActionListener(textArea, accessPath);
			buttonEmpty.addActionListener(actionListenerEmpty);
			activeButton = buttonEmpty;
		}
		if (accessPath.matches(TOURNAMENT)) {
			actionListenerTournament = new TournamentActionListener(textArea,
					accessPath);
			buttonTournament.addActionListener(actionListenerTournament);
			activeButton = buttonTournament;
		}
		if (accessPath.matches(ENDGAME)) {
			actionListenerEndgame = new EndgameActionListener(textArea,
					accessPath);
			buttonEndgame.addActionListener(actionListenerEndgame);
			activeButton = buttonEndgame;
		}
		if (accessPath.matches(EXERCISE)) {
			actionListenerExercise = new ExerciseActionListener(textArea,
					accessPath);
			buttonExercise.addActionListener(actionListenerExercise);
			activeButton = buttonExercise;
		}
		if (accessPath.matches(BOOK)) {
			actionListenerTraining = new BookActionListener(textArea,
					accessPath);
			buttonTraining.addActionListener(actionListenerTraining);
			activeButton = buttonTraining;
		}
		return activeButton;
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	public static void setButtons() {
		buttonWhite = new JButton("Weiß");
		buttonBlack = new JButton("Schwarz");
		buttonEmpty = new JButton("Leeren");
		buttonEndgame = new JButton("Endspiel");
		buttonExercise = new JButton("Übung");
		buttonTournament = new JButton("Turnier");
		buttonTraining = new JButton("Buch");
		buttonArchive = new JButton("Archiv");
	}

	public static void setComponent(JComponent component, int gridXValue,
			int gridYValue, int gridWidth, int gridHeight, double weightXValue,
			double weightYValue, int insertXValue, int insertYValue) {
		gridBagConstraints.gridx = gridXValue;
		gridBagConstraints.gridy = gridYValue;
		gridBagConstraints.gridwidth = gridWidth;
		gridBagConstraints.gridheight = gridHeight;
		gridBagConstraints.weightx = weightXValue;
		gridBagConstraints.weighty = weightYValue;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = insertXValue;
		gridBagConstraints.ipady = insertYValue;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		dialogPanel.add(component);
	}

	public static JPanel setControlPanel() {
		controlPanel = new JPanel();
		controlPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Steuerung"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		controlPanel
				.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
		controlPanel.add(buttonExercise);
		controlPanel.add(buttonTraining);
		controlPanel.add(buttonTournament);
		controlPanel.add(buttonWhite);
		controlPanel.add(buttonBlack);
		controlPanel.add(buttonEndgame);
		controlPanel.add(buttonEmpty);
		controlPanel.add(buttonArchive);
		return controlPanel;
	}

	public static void setDialogLayout() {
		gridBagConstraints = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		dialogPanel = new JPanel();
		dialogPanel.setLayout(gridBagLayout);
	}

	public static JPanel setDisplayPanel(JScrollPane scrollPane) {
		displayPanel = new JPanel();
		displayPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Anzeige"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		displayPanel
				.setLayout(new BoxLayout(displayPanel, BoxLayout.LINE_AXIS));
		displayPanel.add(scrollPane);
		return displayPanel;
	}

	public static void setFrame(String title) {
		dialogFrame = new JFrame(title);
		dialogFrame.getContentPane().add(dialogPanel);
		dialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialogFrame.pack();
		dialogFrame.setVisible(true);
	}

	public static JScrollPane setScrollPane() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(java.awt.Font.getFont(Font.DIALOG));
		dimension = new Dimension(500, 200);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(dimension);
		return scrollPane;
	}

}
