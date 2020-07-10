package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<Book> getAllBook(Pageable pageable);
}
