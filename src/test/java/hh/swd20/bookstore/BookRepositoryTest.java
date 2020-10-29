package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Test  // testataan BookRepositoryn findByAuthor()-metodin toimivuutta (search)
    public void findByAuthorShouldReturnTitle() {
        List<Book> books = brepository.findByAuthor("Kirjailija1");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Kirja1");
    }
    
    @Test // testataan BookRepositoryn save()-metodin toimivuutta (create)
    public void createNewBook() {
    	Book book = new Book("Kirja4", "Kirjailija4", 2013, "ISBN-4000", 33.33, null);
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }

}