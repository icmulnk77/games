package de.domain.games.control;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.domain.games.dialog.Dialog;

/**
 * This is the control class of the application. It sets the look and feel of
 * the application and starts the dialog.
 * 
 * @see de.domain.games.dialog.Dialog
 * @author Tim Schmitz
 * @version 2016/04/26
 */

public class Control {

	// Parameter to control the workflow of the application
	private static final Logger FileLogger = LogManager.getLogger("de.domain.timgames.logger.FileLogger");
	private static final Logger ConsoleLogger = LogManager.getLogger("de.domain.timgames.logger.ConsoleLogger");

	
	/**
	 * The run method sets the look and feel of the application and starts the
	 * dialog
	 */
	public static void run() {
		ConsoleLogger.trace("Main main routine starts...");
		FileLogger.trace("Main main routine starts...");
		setLookAndFeel();
		Dialog.start();
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

}
