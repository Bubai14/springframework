/**
 * 
 */
package playground.app.spring5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import playground.app.spring5.repositories.AuthorRepository;

/**
 * @author bubaibal
 *
 */
@Controller
public class AuthorController {
	
	private final AuthorRepository authorRepository;

	/**
	 * @param authorRepository
	 */
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}
