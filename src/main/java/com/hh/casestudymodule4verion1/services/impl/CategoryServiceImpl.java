package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Category;
import com.hh.casestudymodule4verion1.repositories.CategoryRepository;
import com.hh.casestudymodule4verion1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
