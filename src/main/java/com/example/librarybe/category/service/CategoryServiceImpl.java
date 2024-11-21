package com.example.librarybe.category.service;

import com.example.librarybe.category.data.dao.CategoryDAO;
import com.example.librarybe.category.data.dto.CategoryDTO;
import com.example.librarybe.category.data.entity.Category;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDAO categoryDAO;

  @Override
  public List<CategoryDTO> getCategoryBooks(String name) {
    List<Category> categoryList = categoryDAO.getAllCategories(name);
    return categoryList.stream()
        .map(this::toDTO)
        .toList();
  }
}
