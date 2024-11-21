package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.Book;
import com.example.librarybe.book.data.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookDAOImpl implements BookDAO {

  private final BookRepository bookRepository;

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book getBook(long id) {
    return bookRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("Book not found"));
  };

  @Override
  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book updateBook(Long id, Book book) {
    Book updateBook = bookRepository.findById(id)
        .orElseThrow(()->new IllegalArgumentException("book not found"));

    updateBook.setTitle(book.getTitle());
    updateBook.setAuthor(book.getAuthor());
    updateBook.setPublisher(book.getPublisher());
    updateBook.setDescription(book.getDescription());
    updateBook.setRented(book.isRented());

    return bookRepository.save(updateBook);
  }

  @Override
  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }

}
