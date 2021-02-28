/**
 * 
 */
package playground.app.spring5.preinitalize;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import playground.app.spring5.domain.Author;
import playground.app.spring5.domain.Book;
import playground.app.spring5.domain.Publisher;
import playground.app.spring5.repositories.AuthorRepository;
import playground.app.spring5.repositories.BookRepository;
import playground.app.spring5.repositories.PublisherRepository;

/**
 * Initialize the application with the pre-requisites
 * 
 * @author bubaibal
 *
 */
@Component
public class PreInitializer implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publiserRepository;
	
	
	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public PreInitializer(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publiserRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publiserRepository = publiserRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		// Create first record for Author and Book
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1224543");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		// Save the author and book
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		// Create second record for Author and Book
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("JEE Development without EJB", "34553325");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		// Save the author and book
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		// Add a publisher and save
		Publisher publisher = new Publisher("Pearson", "23/5 Lowdown Street", "Park Circus", "Kolkata", "West Bengal", "700017");
		publisher.getBooks().add(ddd);
		publisher.getBooks().add(noEJB);
		
		// Save the publisher
		publiserRepository.save(publisher);
		
		System.out.println("==App pre initialization completed==");
		System.out.println("Number of Books:"+ bookRepository.count());
		System.out.println("Number of Publisher:"+ publiserRepository.count());
		System.out.println("Number of publisher books:"+ publisher.getBooks().size());
	}

}
