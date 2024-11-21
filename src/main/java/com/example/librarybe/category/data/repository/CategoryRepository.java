package com.example.librarybe.category.data.repository;

import com.example.librarybe.category.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("select c from Category c left join fetch c.books where c.name = :name")
  Category findByNameWithBooks(String name);
}
