package com.guru.springframework.spring5webApp.repositories;

import com.guru.springframework.spring5webApp.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
