package de.domain.games.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TournamentModel {

	private static List<String> games = null;
	private static List<String> yearList = null;
	private static List<String> variationList = null;
	private static List<String> tournamentList = null;

	private static final String PORTABLE_GAME_NOTATION = ".pgn";
	private static final String COMPLETE = "Turniere";
	private static final int BUFFERSIZE = 1024 << 8;

	// Parameter to control the workflow of the application
	private static final Logger FileLogger = LogManager
			.getLogger("de.domain.games.logger.FileLogger");
	private static final Logger ConsoleLogger = LogManager
			.getLogger("de.domain.games.logger.ConsoleLogger");

	public static List<String> getYearList(String tournamentPath) {
		yearList = new ArrayList<String>();
		yearList = GameModel.getDirectories(tournamentPath);
		return yearList;
	}

	public static void processYears(String accessPath) {

		// Iterating over all years
		for (String year : yearList) {
			String yearPath = accessPath + File.separator + year;
			String targetPath = yearPath + PORTABLE_GAME_NOTATION;
			GameWriter.init(targetPath);
			GameWriter.delete();
			tournamentList = new ArrayList<String>();
			tournamentList = GameModel.getDirectories(yearPath);

			// Iterating over all tournaments of the actual year
			for (String tournament : tournamentList) {
				games = new ArrayList<String>();
				String tournamentPath = yearPath + File.separator + tournament;
				variationList = new ArrayList<String>();
				variationList = GameModel.getVariations(tournamentPath);
				games = new ArrayList<String>();
				games = GameModel.getGames(variationList, games);

				// Writing all games in target base
				for (String game : games) {
					GameWriter.write(game);
				}
			}
			GameWriter.close();
		}
	}

	public static void completeYears(String accessPath) {
		String completedPath = accessPath + File.separator + COMPLETE
				+ PORTABLE_GAME_NOTATION;
		File baseDir = new File(accessPath);
		File file = new File(completedPath);
		file.delete();

		// Get the simple names of the files ("foo.log" not
		// "/path/logs/foo.log")
		String[] fileNames = baseDir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(PORTABLE_GAME_NOTATION);
			}
		});

		// Sort the names
		Arrays.sort(fileNames);

		for (String s : fileNames) {
			ConsoleLogger.trace("File: " + s);
		}

		try {
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(completedPath), BUFFERSIZE);
			byte[] bytes = new byte[BUFFERSIZE];
			int bytesRead;
			final byte[] newLine = "\n".getBytes(); // use to separate contents

			for (String s : fileNames) {
				// get the full path to read from
				String fullName = baseDir.getAbsolutePath() + File.separatorChar
						+ s;
				BufferedInputStream in = new BufferedInputStream(
						new FileInputStream(fullName), BUFFERSIZE);
				while ((bytesRead = in.read(bytes, 0, bytes.length)) != -1) {
					out.write(bytes, 0, bytesRead);
				}
				// close input file and ignore any issue with closing it
				try {
					in.close();
				} catch (IOException e) {
				}
				out.write(newLine); // seperation
			}

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
