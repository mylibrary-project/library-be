package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.data.entity.Book;
import java.util.List;

public interface BookService {

  List<BookDTO> getAllBooks();

  BookDTO getBook(long id);

  BookDTO createBook(BookDTO bookDTO);

  BookDTO updateBook(long id, BookDTO bookDTO);

  void deleteBook(long id);

  // entity -> dto
  default BookDTO toDTO(Book book) {
    return BookDTO.builder()
        .id(book.getId())
        .title(book.getTitle())
        .author(book.getAuthor())
        .rented(book.isRented())
        .description(book.getDescription())
        .publisher(book.getPublisher())
        .imgsrc(book.getImgsrc())
        .categoryId(book.getCategory() != null ? book.getCategory().getId() : null)
        .categoryName(book.getCategory() != null ? book.getCategory().getName() : null)
        .build();
  }

  // dto -> entity
  default Book toEntity(BookDTO bookDTO) {
    return Book.builder()
        .title(bookDTO.getTitle())
        .author(bookDTO.getAuthor())
        .rented(bookDTO.isRented())
        .description(bookDTO.getDescription())
        .publisher(bookDTO.getPublisher())
        .imgsrc("http://via.placeholder.com/150x150/00ff00")
        .build();
  }
}
