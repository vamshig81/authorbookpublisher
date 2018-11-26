package guru.springframework.spring5webapp.Repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;
/**
created by vamshidhar gade on 11/16/18
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
