package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.Book;
import java.util.List;


public interface BookDAO {

  /**
   * DB에서 모든 책 정보 가져오기
   * @return 모든 책 정보
   */
  List<Book> getAllBooks();

  /**
   * DB에서 책 한권 정보 가져오기
   * @param id
   * @return 책 한권
   */
  Book getBook(long id);

  /**
   * DB에 책 추가하기
   * @param book
   * @return 책 추가
   */
  Book addBook(Book book);

  /**
   * DB에 책 정보 수정하기
   * @param id
   * @param book
   * @return 수정된 책 정보
   */
  Book updateBook(Long id, Book book);

  /**
   * DB에 책 정보 삭제하기
   * @param id
   */
  void deleteBook(Long id);

  /**
   * 카테고리 별 모든 책 정보 가져오기
   * @param categoryId
   * @return 카테고리 별 모든 책 정보
   */
  List<Book> getAllBooksByCategory(Long categoryId);
}
