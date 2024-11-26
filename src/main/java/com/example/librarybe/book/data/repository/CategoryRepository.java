package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  /**
   * left join 해서 category와 books 합쳐서 카테고리 이름 정보 가져오기
   * @param name
   * @return categoryName
   */
  @Query("select c from Category c left join fetch c.books where c.name = :name")
  Category findByNameWithBooks(@Param("name") String name);
}
