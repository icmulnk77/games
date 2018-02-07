package de.domain.games.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import de.domain.games.model.BookModel;
import de.domain.games.model.ExerciseModel;


public class BookActionListener implements ActionListener {
	
	private static JTextArea activeTextArea = null; 	
	private static String activeAccessPath = null;
	private static List<String> bookList = null;
	
	public BookActionListener(JTextArea textArea, String accessPath) {
		activeTextArea = textArea;
		activeAccessPath = accessPath;
		bookList = new ArrayList<String>();
	}
	
  public void actionPerformed(ActionEvent event) {
   	activeTextArea.append("Aktueller Zugriffspfad: " + activeAccessPath + "\n");
  	bookList = BookModel.getBookList(activeAccessPath);
  	BookModel.processBook(activeAccessPath);
  	for (String book : bookList) {
  		activeTextArea.append(book + "\n");
  	}
  }
}
