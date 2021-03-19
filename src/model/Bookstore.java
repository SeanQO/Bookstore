package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import collections.IHashTable;
import collections.TheHashTable;

public class Bookstore {
	
	private List<Book> booksAvailable;
	private List<Client> clients;
	
	private IHashTable<Integer, Book > shelving1;
	private IHashTable<Integer, Book > shelving2;
	private IHashTable<Integer, Book > shelving3;
	 
	
	
	public Bookstore() {
		
		booksAvailable = new ArrayList<Book>();
		clients = new ArrayList<Client>();
		shelving1 = new TheHashTable<>();
		shelving2 = new TheHashTable<>();
		shelving3 = new TheHashTable<>();
	}
	
	public void addClient(String name, int id) {
		Client newClient = new Client(name, id);
		clients.add(newClient);
		
	}
	
	public List<Client> getClients(){
		return clients;
	}
	
	public List<Book> getBooksAvailable() {
		return booksAvailable;
	}

	/* 
	 * Seccion 1 donde los clientes de la libreria pueden ver el listado
	 * de tods los libros disponibles en la tienda y ademas, puede leer
	 * los primeros capitulos, reseñas y criticas que esten publicadas
	 * sobre dicha obra.
	 * Al final el cliente optiene los codigos ISBN de los libros que
	 * desea adquirir.
	  */
	public void SectionOne() {
		
	}
	
	/*
	 * Seccion 2 donde el cliente debe ingresar los codigos ISBN para que
	 * un algoritmo trace la ruta mas eficiente para encontrar los libros 
	 * a aquirir en cada uno de los estantes fisicos de la libreria.
	 */
	public void SectionTwo() {
		
	}
	
	/*
	 * Seccion 3  El clinete recoge los libros y los almacena en un canasto
	 * asignado para ubicar los libros uno encima del otros en orden
	 * suministrado en la etapa anterior.
	 */
	public void SectionThree() {
		
	}
	
	/*
	 * Seccion 4 donde el cliente pasa al area de pago, sin embargo su lugar
	 * en la fila va a depender del tiempo que le haya tomado entrar a la tienda,
	 * mas el tiempo que tarde en recoger los libros.
	 * Todos hacen una sola fila
	 */
	public void SectionFour() {
		
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
			if (book.getIsbn() >= 1000 && book.getIsbn() < 2000) {
				shelving1.add(Integer.parseInt(split[4]), book);

			}
			if (book.getIsbn() >= 2000 && book.getIsbn() < 3000) {
				shelving2.add(Integer.parseInt(split[4]), book);

			}
			if (book.getIsbn() >= 3000 && book.getIsbn() <= 4000) {
				shelving3.add(Integer.parseInt(split[4]), book);

			}
			booksAvailable.add(book);
			line = br.readLine();

		}
		
		//System.out.println(shelving.isEmpty()+"");
		//System.out.println(shelving.getSize()+"");
	}
	
	
}
