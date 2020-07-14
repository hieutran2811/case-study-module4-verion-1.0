package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Category;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
    List<Book> findAllByCategoryList(Category category);

}
