package com.example.librarybe.category.service;

import com.example.librarybe.category.data.dto.CategoryDTO;
import com.example.librarybe.category.data.entity.Category;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> getCategoryBooks(String name);

  default CategoryDTO toDTO(Category category) {
    if (category == null) {
      return null;
    }
    return CategoryDTO.builder()
        .id(category.getId())
        .name(category.getName())
        .bookCount(category.getBooks().size())
        .build();
  }
}
