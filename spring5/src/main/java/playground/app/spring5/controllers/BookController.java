/**
 * 
 */
package playground.app.spring5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import playground.app.spring5.repositories.BookRepository;

/**
 * @author bubaibal
 *
 */
@Controller
public class BookController {

	private final BookRepository bookRepository;

	/**
	 * @param bookRepository
	 */
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		return "view.books";
	}
}
