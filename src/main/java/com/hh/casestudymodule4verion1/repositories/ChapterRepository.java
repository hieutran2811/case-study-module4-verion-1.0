package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends PagingAndSortingRepository<Chapter,Long> {
    List<Chapter> findChaptersByBook(Book book);
    Page<Chapter> findChaptersByBook(Pageable pageable, Book book);
}
