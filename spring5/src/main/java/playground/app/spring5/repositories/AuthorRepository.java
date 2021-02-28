/**
 * 
 */
package playground.app.spring5.repositories;

import org.springframework.data.repository.CrudRepository;

import playground.app.spring5.domain.Author;

/**
 * @author bubaibal
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
