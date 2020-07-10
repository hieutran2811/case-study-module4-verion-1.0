package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.repositories.BookRepository;
import com.hh.casestudymodule4verion1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
