package com.guru.springframework.spring5webApp.repositories;

import com.guru.springframework.spring5webApp.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
