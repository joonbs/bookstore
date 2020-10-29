package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.webcontroller.BookController;
import hh.swd20.bookstore.webcontroller.CategoryController;

//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
public class BookstoreApplicationTests {

	// inject controllers
	@Autowired
	private BookController bookController;
	@Autowired
	private CategoryController categoryController;
	
	// smoke testing controllers 
	@Test
	public void bookLoads() {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void categoryLoads() {
		assertThat(categoryController).isNotNull();
	}
}