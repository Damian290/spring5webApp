package com.guru.springframework.spring5webApp.bootstrap;

import com.guru.springframework.spring5webApp.Model.Author;
import com.guru.springframework.spring5webApp.Model.Book;
import com.guru.springframework.spring5webApp.Model.Publisher;
import com.guru.springframework.spring5webApp.repositories.AuthorRepository;
import com.guru.springframework.spring5webApp.repositories.BookRepository;
import com.guru.springframework.spring5webApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Publisher publisher = new Publisher();
        publisher.setName("Colonel");
        publisher.setAddress("Nad Drwina 4b");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //ROD
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
