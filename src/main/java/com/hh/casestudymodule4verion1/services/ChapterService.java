package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
public interface ChapterService {
    List<Chapter> getChaptersByBook(Book book);
}
