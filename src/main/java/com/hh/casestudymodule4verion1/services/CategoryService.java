package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);

}
