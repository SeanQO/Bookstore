package ui;

import java.io.IOException;

import model.Bookstore;

public class Menu {
	
	private static Bookstore bs; 
	
	public Menu() {
		
	}
	
	private static void importDataBooks() throws IOException {
		String dataLink = "data/bookList.csv";
		bs.importDataBooksList(dataLink);
	}
}