package de.domain.games.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import de.domain.games.util.Property;

public class Archivar {
	private static final int BUFFER = 2048;
	private static String archiveDirectory = null;
	private static String whiteDirectory = null; 
	private static String blackDirectory = null;
	private static String tournamentDirectory = null;
		
	public static void process() {
		archiveDirectory = Property.getArchive();
		whiteDirectory = Property.getWhite();
		blackDirectory = Property.getBlack();
		tournamentDirectory = Property.getTournament();
		String date = LocalDate.now().toString();
		archive(archiveDirectory, whiteDirectory, date, "Weiß");
		archive(archiveDirectory, blackDirectory, date, "Schwarz");
		archive(archiveDirectory, tournamentDirectory, date, "Turnier");
	}
	
	public static List<String> addGames(String directory, List<String> list) {
		List<String> gamesList = list;
		File directoryFile = new File(directory);
    String[] games = directoryFile.list(); 
		for (String gameCandidate : games) {
			String gamePath = directory + File.separator + gameCandidate;
			File gameFile = new File(gamePath);
			if (gameFile.isDirectory()) addGames(gamePath, gamesList);
			if (gameFile.isFile()) gamesList.add(gamePath);
		}
		return gamesList;
	}
		
	public static void archive(String archive, String directory, String date, String archiveName) {
		String archivePath = archive + File.separator + archiveName + "_" + date + ".zip"; 
		List<String> archivedGames = new ArrayList<String>();
		archivedGames = addGames(directory,archivedGames);
		
//		File directoryFile = new File(directory);
//    String[] games = directoryFile.list(); 
//		for (String gameCandidate : games) {
//			String gamePath = directory + File.separator + gameCandidate;
//			File gameFile = new File(gamePath);
//			if (gameFile.isFile()) archivedGames.add(gamePath);
//		}

		try {
			BufferedInputStream bufferedInputStream = null;
			FileOutputStream fileOutputStream = new FileOutputStream(archivePath);
			ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
			byte data[] = new byte[BUFFER];
		
			for (String archivedGame : archivedGames) {
				//				File archivedFile = new File(archivedGame);
				System.out.println("Archiving " + archivedGame);
				FileInputStream fileInputStream = new FileInputStream(archivedGame);
				bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER);
				ZipEntry entry = new ZipEntry(archivedGame);
				zipOutputStream.putNextEntry(entry);
				int count;
				while((count = bufferedInputStream.read(data, 0, BUFFER)) != -1) {
					zipOutputStream.write(data, 0, count);
				}
				bufferedInputStream.close();
			}	 
		zipOutputStream.close();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
	
	
			 
