package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Saving some book data...");
			crepository.save(new Category("Science"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Fantasy"));
			
			brepository.save(new Book("Kirja1", "Kirjailija1", 1960, "ISBN-1000", 15.00, crepository.findByName("Science").get(0)));
			brepository.save(new Book("Kirja2", "Kirjailija2", 2000, "ISBN-2000", 25.00, crepository.findByName("History").get(0)));
			brepository.save(new Book("Kirja3", "Kirjailija3", 2018, "ISBN-3000", 19.80, crepository.findByName("Fantasy").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
		};
		
	}
	
}