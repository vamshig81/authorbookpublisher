package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import guru.springframework.spring5webapp.Repositories.PublisherRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private PublisherRepository publisherRepository;

    private void initData(){
        Publisher publisher = new Publisher();
        //publisher.setAddress("NJ");
        publisher.setName("vagade");

        publisherRepository.save(publisher);
        //vamshi
        Author vamshi = new Author("vamshidhar","gade");
        Book microServices = new Book("micro services", "1212",publisher);
        vamshi.getBooks().add(microServices);
        microServices.getAuthors().add(vamshi);
        authorRepository.save(vamshi);
        bookRepository.save(microServices);

        //saanvi
        Author saanvi = new Author("saanvi","gade");
        Book springOnly = new Book("spring starter", "9988", publisher);
        saanvi.getBooks().add(springOnly);
        authorRepository.save(saanvi);
        bookRepository.save(springOnly);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }
}
