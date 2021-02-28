/**
 * 
 */
package playground.app.spring5.repositories;

import org.springframework.data.repository.CrudRepository;

import playground.app.spring5.domain.Book;

/**
 * @author bubaibal
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
