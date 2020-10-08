package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// attributes
	public Long categoryId;		
	public String name;
		
		// relationship
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		// use JsonIgnore(+Properties) to avoid infinite loops during JSON serialization
		@JsonIgnoreProperties("category") 
		public List<Book> books;
		
		// constructor without attributes
		public Category() {}
		
		// constructors
		public Category(String name) {
			super();
			this.name = name;
		}
		
		// getters and setters
		public Long getCategoryid() {
			return categoryId;
		}
		
		public void setCategoryid(Long categoryId) {
			this.categoryId = categoryId;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public List<Book> getBooks() {
			return books;
		}
		public void setBooks(List<Book> books) {
			this.books = books;
		}

		// toString method
		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", name=" + name + "]";
		}
		
	
}
