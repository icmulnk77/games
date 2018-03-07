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
 * @version 2018/02/07
 */
public class Main {

	// Logger kontrolliert den Datenfluss und die Aufrufhierarchie
	private static final Logger LOG = LogManager
			.getLogger(Main.class.getName());

	/**
	 * Die Main-Methode der Applikation startet die Applikation und delegiert an
	 * eine interne statische Routine weiter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Den Start loggen
		LOG.trace("Main main routine starts...");

		// Umleitung
		Main.run();
	}

	/**
	 * Die Ablaufmethode der Applikation übergibt den Kontrollfluss
	 */
	public static void run() {
		LOG.trace("Main run routine starts...");
		Control.run();
	}

}