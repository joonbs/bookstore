package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	// list all books
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	// add book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	// save book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";	
	}

}