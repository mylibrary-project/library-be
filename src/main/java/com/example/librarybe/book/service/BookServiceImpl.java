package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dao.BookDAO;
import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.data.entity.Book;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO;

  @Override
  public List<BookDTO> getAllBooks() {
    return bookDAO.getAllBooks().stream()
        .map(this::toDTO)
        .toList();
  }

  @Override
  public BookDTO getBook(long id) {
    Book book = bookDAO.getBook(id);
    return toDTO(book);
  }

  @Override
  public BookDTO createBook(BookDTO bookDTO) {
    Book book = toEntity(bookDTO);
    Book saveBook = bookDAO.addBook(book);
    return toDTO(saveBook);
  }

  @Override
  public BookDTO updateBook(long id, BookDTO bookDTO) {
    Book updatedBook = toEntity(bookDTO);
    updatedBook.setId(id);

    Book resultBook = bookDAO.updateBook(id, updatedBook);
    return toDTO(resultBook);
  }

  @Override
  public void deleteBook(long id) {
    bookDAO.deleteBook(id);
  }
}
