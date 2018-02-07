package de.domain.games.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameWriter {

	private static OutputStream outputStream = null;
	private static Writer writer = null;
	private static String outputPath = null;

	private static final Logger ConsoleLogger = LogManager
			.getLogger("de.domain.games.logger.ConsoleLogger");

	public static void init(String targetPath) {
		outputPath = targetPath;
		ConsoleLogger.trace("Create " + outputPath);
		try {
			outputStream = new FileOutputStream(outputPath);
			writer = new OutputStreamWriter(outputStream);
		} catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}

	}

	public static void write(String expression) {
		try {
			writer.write(expression);
		} catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}
	}

	// Closing the writer
	public static void close() {
		try {
			writer.close();
			ConsoleLogger.trace("Close writer    ");
		} catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}
	}

	// Deleting a file
	public static void delete() {
		File file = new File(outputPath);
		file.delete();
	}
}
