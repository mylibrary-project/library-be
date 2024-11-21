package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.Book;
import java.util.List;
import org.springframework.stereotype.Service;


public interface BookDAO {

  List<Book> getAllBooks();

  Book getBook(long id);

  Book addBook(Book book);

  Book updateBook(Long id, Book book);

  void deleteBook(Long id);
}
