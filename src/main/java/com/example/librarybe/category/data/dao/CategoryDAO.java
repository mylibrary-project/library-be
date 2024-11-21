package com.example.librarybe.category.data.dao;

import com.example.librarybe.category.data.entity.Category;
import java.util.List;

public interface CategoryDAO {

  /**
   * 모든 카테고리 이름 정보 가져오기
   * @param name
   * @return 카테고리 이름
   */
  List<Category> getAllCategories(String name);
}
