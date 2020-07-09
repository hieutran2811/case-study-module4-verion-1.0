package com.hh.casestudymodule4verion1.repositories.account;

import com.hh.casestudymodule4verion1.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
