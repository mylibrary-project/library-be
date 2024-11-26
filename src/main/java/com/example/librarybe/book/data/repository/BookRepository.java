package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

  /**
   * book에 있는 category_id값 찾기
   * @param categoryId
   * @return category_id
   */
  @Query("select b from Book b where b.category.id = :categoryId")
  List<Book> findByCategory(@Param("categoryId") Long categoryId);

  @Query("select b from Book b where b.title like %:title%")
  List<Book> searchBook(@Param("title") String title);
}
