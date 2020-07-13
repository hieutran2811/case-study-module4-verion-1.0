package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import com.hh.casestudymodule4verion1.repositories.ChapterRepository;
import com.hh.casestudymodule4verion1.services.ChapterService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;
    @Override
    public List<Chapter> getChaptersByBook(Book book) {
        return chapterRepository.findChaptersByBook(book);
    }
}
