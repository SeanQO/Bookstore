package model;

public class Text {
	
	private String name;
	private String author;
	private String editorial;
	private int nPages;
	
	public Text(String name, String author, String editorial, int nPages) {
		this.name = name;
		this.author = author;
		this.editorial = editorial;
		this.nPages = nPages;
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getnPages() {
		return nPages;
	}

	public void setnPages(int nPages) {
		this.nPages = nPages;
	}
	
	
}
