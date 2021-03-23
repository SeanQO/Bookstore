package model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import collections.IHashTable;
import collections.Queue;
import collections.TheHashTable;

public class Bookstore {
	
	private List<Book> booksAvailable;
	private List<Client> clients;
	private Cashier[] cashiers;
	
	private Queue<Client> clientsQueue;
	
	private IHashTable<Integer, Book > shelving1;
	private IHashTable<Integer, Book > shelving2;
	private IHashTable<Integer, Book > shelving3;
	 
	
	
	public Bookstore() {
		
		booksAvailable = new ArrayList<Book>();
		clients = new ArrayList<Client>();
		clientsQueue = new Queue<Client>();
		cashiers = new Cashier[4];
		cashiers[0] = new Cashier();
		cashiers[1] = new Cashier();
		cashiers[2] = new Cashier();
		cashiers[3] = new Cashier();
		shelving1 = new TheHashTable<>();
		shelving2 = new TheHashTable<>();
		shelving3 = new TheHashTable<>();
		
	}
	
	public void nextStep() {
		for (int i = 0; i < cashiers.length; i++) {
			if (cashiers[i].getClient() == null && cashiers[i].isAvaliable()) {
				if (!clientsQueue.isEmpty()) {
					cashiers[i].setClient(clientsQueue.front().getT());
					clientsQueue.dequeue();
				}
				
			}else if (cashiers[i].getClient() != null && cashiers[i].isAvaliable()) {
				if(cashiers[i].getClient().getBasket().size == 0) {
					cashiers[i] = new Cashier();
					
				}else {
					cashiers[i].nextStep();
					
				}
				
			}
			
			
		}
		
	}
	
	/*
	 else if(cashiers[i].getClient().getBasket().size <= 0) {
				cashiers[i] = new Cashier();
				if (!clientsQueue.isEmpty()) {
					cashiers[i].setClient(clientsQueue.front().getT());
					clientsQueue.dequeue();
				}
				
			}else {
				cashiers[i].nextStep();
				
			}
	 */
	
	public void addClient(String name, int id) {
		Client newClient = new Client(name, id);
		clients.add(newClient);
		
	}
	
	public  void addClientToCashier (Client client, int cashierNumber){
		cashiers[cashierNumber].setClient(client);
	}
	
	public List<Client> getClients(){
		return clients;
	}
	
	public void addClientToQueue(Client client) {
		clientsQueue.enqueue(client);
	}
	
	public Queue<Client> getClientsQueue(){
		return clientsQueue;
	}
	
	public List<Book> getBooksAvailable() {
		return booksAvailable;
	}


	
	public Cashier[] getCashiers() {
		return cashiers;
	}

	public void importDataBooksList(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(",");
			Book book = new Book(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]),
					Double.parseDouble(split[5]), split[6], split[7]);
			if (book.getIsbn() >= 100 && book.getIsbn() < 200) {
				shelving1.add(Integer.parseInt(split[4]), book);

			}
			if (book.getIsbn() >= 200 && book.getIsbn() < 300) {
				shelving2.add(Integer.parseInt(split[4]), book);

			}
			if (book.getIsbn() >= 300 && book.getIsbn() <= 400) {
				shelving3.add(Integer.parseInt(split[4]), book);

			}
			booksAvailable.add(book);
			line = br.readLine();

		}
		
		//System.out.println(shelving.isEmpty()+"");
		//System.out.println(shelving.getSize()+"");
	}
	
	public Book searchBook(int isbnForSearch) {
		Book searched = null;
		if (isbnForSearch >= 100 && isbnForSearch < 200) {
			searched = shelving1.get(isbnForSearch);
		}
		if (isbnForSearch >= 200 && isbnForSearch < 300) {

			searched = shelving2.get(isbnForSearch);
		}
		if (isbnForSearch >= 300 && isbnForSearch <= 400) {
			searched = shelving3.get(isbnForSearch);
		}

		return searched;
	}
	
	public String searchLocation(int isbn) {
		String m = "The Book is in the shelving ";
	
		if (isbn >= 100 && isbn < 200) {
			m += "one and the level " + shelving1.getSlotIndex(isbn) + " .";
			
		}
		if (isbn >= 200 && isbn < 300) {

			m += "two and the level " + shelving2.getSlotIndex(isbn) + " .";
		}
		if (isbn >= 300 && isbn <= 400) {
			m += "three and the level " + shelving3.getSlotIndex(isbn) + " .";
		}
		return m;
	}
	
	
	  /*
    public ArrayList<Book> booksToArray(){
	   ArrayList<Book> booksArray = new ArrayList<>();
		Stack<Book> tempBasket = new Stack<Book>();
		while(!tempBasket.isEmpty()) {
			SElement<Book> temp = tempBasket.pop().getT();
			booksArray.add(temp);
		}

	   return booksArray;
	   
	   
   }
   */ 
	
	
	

}
	 
