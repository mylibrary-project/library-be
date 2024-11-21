package com.example.librarybe.category.data.dao;

import com.example.librarybe.category.data.entity.Category;
import java.util.List;

public interface CategoryDAO {

  List<Category> getAllCategories(String name);
}
