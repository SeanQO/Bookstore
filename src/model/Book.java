package model;

public class Book extends Text {
	
	
	private int isbn;
	private double price;
	private String initialChapters;
	private String review;
	
	public Book(String name, String author, String editorial, int nPages, int isbn, double price, String initialChapters, String review) {
		super(name, author, editorial, nPages);
		this.isbn = isbn;
		this.price = price;
		this.initialChapters = initialChapters;
		this.review = review;
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
