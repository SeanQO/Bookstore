package model;

public class Book {
	
	private String name;
	private String author;
	private int isbn;
	private double price;
	private String initialChapters;
	private String review;
	
	public Book(String name, String author, int isbn, double price, String initialChapters, String review) {
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.initialChapters = initialChapters;
		this.review = review;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInitialChapters() {
		return initialChapters;
	}

	public void setInitialChapters(String initialChapters) {
		this.initialChapters = initialChapters;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
}
