package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChapterService {
    List<Chapter> getChaptersByBook(Book book);
    Page<Chapter> getChaptersByBook(Pageable pageable, Book book);
    Optional<Chapter> getChapterById(Long id);
    Optional<Chapter> getChapterByChapterAndBook(Long chapterNumber,Book book);


    void save(Chapter chapter);
    void remove(Chapter chapter);
}
