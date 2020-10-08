package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// attributes
	public Long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	// relationships & Category constructor
	@ManyToOne
	// @JsonIgnoreProperties - one way to avoid infinite loop during JSON serialization/deserialization with bidirectional relationships
	@JsonIgnoreProperties("categories")
	@JoinColumn(name = "categoryId")
	private Category category;
	
	// constructor without attributes
	public Book() {}
	
	// constructors
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	// getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	// toString method
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + ", category =" + this.getCategory() + "]";
	}
	
}