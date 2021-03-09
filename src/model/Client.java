package model;
import java.util.ArrayList;
import java.util.Stack;

public class Client {
	ArrayList<Integer> isnbList;
	Stack<Book> basket;
	double timeInStore;
	
	public Client() {
		isnbList = new ArrayList<Integer>();
		basket = new Stack<Book>();
		timeInStore = 0;
		
	}
	
	public ArrayList<Integer> getIsnbList() {
		return isnbList;
	}

	public Stack<Book> getBasket() {
		return basket;
	}
	
	public double getTimeInStore() {
		return timeInStore;
	}
	
	public void addBookToBasket(Book book) {
		basket.add(book);
		
	}
	
	public void addIsnbToList(int isnb) {
		isnbList.add(isnb);
		
	}
	
	public void sortIsnbList(int sortingMethod) {
		switch (sortingMethod) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;

		}
		
	}
	
	public void addTime(double time) {
		timeInStore += time; 
	}
	
	
}