package guru.springframework.spring5webapp.Repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 created by vamshidhar gade on 11/16/18
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
