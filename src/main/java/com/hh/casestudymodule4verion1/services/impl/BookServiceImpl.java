package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Category;
import com.hh.casestudymodule4verion1.repositories.BookRepository;
import com.hh.casestudymodule4verion1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findBooksByCategory(Category category) {
        return bookRepository.findAllByCategoryList(category);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book increaseLike(Book book) {
        book.setLikeBook(book.getLikeBook()+1);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book decreaseLike(Book book) {
        book.setLikeBook(book.getLikeBook()-1);
        bookRepository.save(book);
        return book;
    }


}
