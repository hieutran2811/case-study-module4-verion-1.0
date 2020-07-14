package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import java.util.List;
public interface BookService {

    Page<Book> getAllBook(Pageable pageable);

    Optional<Book> getBookById(Long id);

    List<Book> findBooksByCategory(Category category);
}
