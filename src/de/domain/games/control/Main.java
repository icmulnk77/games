package de.domain.games.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Diese Klasse definiert die Hauptklasse der Applikation. Sie delegiert den
 * Kontrollfluss weiter
 * 
 * @see de.domain.games.control.Main
 * @author Tim Schmitz
 * @version 2016/04/26
 */
public class Main {

	// Die beiden Logger kontrollieren den Datenfluss und die Aufrufhierarchie
	private static final Logger FileLogger = LogManager
			.getLogger("de.domain.timgames.logger.FileLogger");
	private static final Logger ConsoleLogger = LogManager
			.getLogger("de.domain.timgames.logger.ConsoleLogger");

	/**
	 * Die Main-Methode der Applikation startet die Applikation und delegiert an
	 * eine interne statische Routine weiter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Den Start loggen
		ConsoleLogger.trace("Main main routine starts...");
		FileLogger.trace("Main main routine starts...");

		// Umleitung
		Main.run();
	}

	/**
	 * Die Ablaufmethode der Applikation übergibt den Kontrollfluss
	 */
	public static void run() {
		ConsoleLogger.trace("Main run routine starts...");
		FileLogger.trace("Main run routine starts...");
		Control.run();
	}

}