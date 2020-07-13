package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChapterRepository extends PagingAndSortingRepository<Chapter,Long> {
    List<Chapter> findChaptersByBook(Book book);
}
