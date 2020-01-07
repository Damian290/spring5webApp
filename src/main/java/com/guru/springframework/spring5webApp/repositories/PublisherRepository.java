package com.guru.springframework.spring5webApp.repositories;

import com.guru.springframework.spring5webApp.Model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
