package de.domain.games.dialog;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.domain.games.dialog.Builder;
import de.domain.games.util.Property;

/**
 * This is the dialog class of the application. It initializes the application,
 * sets the UI components and builds the applications components
 * 
 * @see de.domain.games.util.Property
 * @see de.domain.games.dialog.Builder
 * @author Tim Schmitz
 * @version 1.0
 */
public class Dialog {

	// Static strings for the application
	private static String APPLICATION = null;
	private static String ARCHIVE = null;
	private static String BASE = null;
	private static String BLACK = null;
	private static String ENDGAME = null;
	private static String EXERCISE = null;
	private static String TOURNAMENT = null;
	private static String BOOK = null;
	private static String WHITE = null;

//	private static JPanel dialogPanel = null;
	private static JPanel displayPanel = null;
	private static JScrollPane scrollPane = null;
	private static JPanel controlPanel = null;
	private static JTextArea textArea = null;

	private static JButton buttonArchive;
	private static JButton buttonBlack = null;
	private static JButton buttonEmpty = null;
	private static JButton buttonEndgame = null;
	private static JButton buttonExercise = null;
	private static JButton buttonTournament = null;
	private static JButton buttonBook = null;
	private static JButton buttonWhite = null;

	public static void build() {
		Builder.setComponent(controlPanel, 0, 0, 1, 1, 0.5, 0.5, 1, 1);
		Builder.setComponent(displayPanel, 0, 1, 2, 1, 0.5, 0.5, 1, 1);
		Builder.setFrame(APPLICATION);
		setLookAndFeel();
	}

	/**
	 * The initialize method sets and loads the properties. It sets the static
	 * strings for the application.
	 */
	public static void initialize() {
		Property.setProperties();
		Property.load();
		APPLICATION = Property.getApplication();
		ARCHIVE = Property.getArchive();
		BASE = Property.getBase();
		BLACK = Property.getBlack();
		BOOK = Property.getBook();
		ENDGAME = Property.getEndgame();
		EXERCISE = Property.getExercise();
		TOURNAMENT = Property.getTournament();
		WHITE = Property.getWhite();
	}

	public static void setControls() {
		textArea = Builder.getTextArea();
		buttonWhite = Builder.activateButton(textArea, WHITE);
		buttonBlack = Builder.activateButton(textArea, BLACK);
		buttonEmpty = Builder.activateButton(textArea, BASE);
		buttonEndgame = Builder.activateButton(textArea, ENDGAME);
		buttonExercise = Builder.activateButton(textArea, EXERCISE);
		buttonTournament = Builder.activateButton(textArea, TOURNAMENT);
		buttonBook = Builder.activateButton(textArea, BOOK);
		buttonArchive = Builder.activateButton(textArea, ARCHIVE);
	}

	/**
	 * The setLookAndFeel method sets the look and feel by the UI manager
	 */
	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException systemException) {
			systemException.getMessage();
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.getMessage();
		} catch (InstantiationException instantiationException) {
			instantiationException.getMessage();
		} catch (IllegalAccessException illegalAccessException) {
			illegalAccessException.getMessage();
		}
	}

	/**
	 * The setPanels method sets the dialog panel
	 */
	public static void setPanels() {
		Builder.setDialogLayout();
		scrollPane = Builder.setScrollPane();
		displayPanel = Builder.setDisplayPanel(scrollPane);
		Builder.setButtons();
		controlPanel = Builder.setControlPanel();
	}

	/**
	 * The start method initializes the dialog, sets the panels and controls for
	 * the application and builds its components to the dialog.
	 */
	public static void start() {
		initialize();
		setPanels();
		setControls();
		build();
	}

}