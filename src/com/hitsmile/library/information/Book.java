package com.hitsmile.library.information;

public class Book {
	
	private int id;
	private int num;
	private int pageCount;
	private double price;
	private String name;
	private String author;
	private String pubComp;
	private String pubDate;
	private String inDate;
	private String location;
	
	public Book(int id, int num, int pageCount, double price, String name,
			String author, String pubComp, String pubDate, String inDate,
			String location) {
		super();
		this.id = id;
		this.num = num;
		this.pageCount = pageCount;
		this.price = price;
		this.name = name;
		this.author = author;
		this.pubComp = pubComp;
		this.pubDate = pubDate;
		this.inDate = inDate;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPubComp() {
		return pubComp;
	}

	public void setPubComp(String pubComp) {
		this.pubComp = pubComp;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", num=" + num + ", pageCount=" + pageCount
				+ ", price=" + price + ", name=" + name + ", author=" + author
				+ ", pubComp=" + pubComp + ", pubDate=" + pubDate + ", inDate="
				+ inDate + ", location=" + location + "]";
	}

	
}
