package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dao.CategoryDAO;
import com.example.librarybe.book.data.dto.CategoryDTO;
import com.example.librarybe.book.data.entity.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDAO categoryDAO;

  @Transactional(readOnly = true)
  @Override
  public List<CategoryDTO> getCategoryBooks(String name) {
    List<Category> categoryList = categoryDAO.getAllCategories(name);
    return categoryList.stream()
        .map(this::toDTO)
        .toList();
  }
}
