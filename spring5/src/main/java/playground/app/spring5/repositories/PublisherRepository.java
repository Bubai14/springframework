/**
 * 
 */
package playground.app.spring5.repositories;

import org.springframework.data.repository.CrudRepository;

import playground.app.spring5.domain.Publisher;

/**
 * @author bubaibal
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
