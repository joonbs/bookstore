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
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Saving some book data...");
			// Create categories
			crepository.save(new Category("Science"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Fantasy"));
			
			// Add some book data
			brepository.save(new Book("Kirja1", "Kirjailija1", 1960, "ISBN-1000", 15.00, crepository.findByName("Science").get(0)));
			brepository.save(new Book("Kirja2", "Kirjailija2", 2000, "ISBN-2000", 25.00, crepository.findByName("History").get(0)));
			brepository.save(new Book("Kirja3", "Kirjailija3", 2018, "ISBN-3000", 19.80, crepository.findByName("Fantasy").get(0)));
			
			// Create users: username: admin, password: admin & user/user
			User user1 = new User("user", "$2a$10$ygrX9.DuLjOHihmHSyHhc.S4cZQhaTCYXZAGksML1rEZww6nvtoaG", "USER", "user@mail.com");
			User user2 = new User("admin", "$2a$10$QcNwujpuCwUJSrrbnrnz2O27Hf.HcUXx7nGq1apgARRDIbsIWehsK", "ADMIN", "admin@mail.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
		};
		
	}
	
}