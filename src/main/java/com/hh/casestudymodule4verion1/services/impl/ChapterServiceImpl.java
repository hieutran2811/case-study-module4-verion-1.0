package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import com.hh.casestudymodule4verion1.repositories.ChapterRepository;
import com.hh.casestudymodule4verion1.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;
    @Override
    public List<Chapter> getChaptersByBook(Book book) {
        return chapterRepository.findChaptersByBook(book);
    }

    @Override
    public Page<Chapter> getChaptersByBook(Pageable pageable, Book book) {
        return chapterRepository.findChaptersByBook( pageable,book);
    }

    @Override
    public Optional<Chapter> getChapterById(Long id) {
        return chapterRepository.findChapterById(id);
    }

    @Override
    public Optional<Chapter> getChapterByChapterAndBook(Long chapterNumber, Book book) {
        return chapterRepository.findChapterByChaptersAndBook(chapterNumber,book);
    }


    @Override
    public void save(Chapter chapter) {
        chapterRepository.save(chapter);
    }

    @Override
    public void remove(Chapter chapter) {
        chapterRepository.delete(chapter);
    }
}
