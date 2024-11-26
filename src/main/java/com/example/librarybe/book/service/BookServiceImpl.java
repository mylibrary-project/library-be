package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dao.BookDAO;
import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.data.entity.Book;
import com.example.librarybe.book.data.dao.CategoryDAO;
import com.example.librarybe.book.data.entity.Category;
import com.example.librarybe.book.data.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO;
  private final CategoryDAO categoryDAO;
  private final CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  @Override
  public List<BookDTO> getAllBooks(Long categoryId) {

    log.info("getAllBooks start... ");
    if(categoryId == null) {
      return bookDAO.getAllBooks().stream().map(this::toDTO).toList();
    }

    categoryRepository.findById(categoryId)
            .orElseThrow(() -> new EntityNotFoundException("Category not found categoryId: " + categoryId));

    return bookDAO.getAllBooksByCategory(categoryId).stream()
        .map(this::toDTO)
        .toList();

  }

  @Transactional(readOnly = true)
  @Override
  public BookDTO getBook(long id) {

    log.info("getBook start... ");
    Book book = bookDAO.getBook(id);
    return toDTO(book);
  }

  @Override
  public BookDTO createBook(BookDTO bookDTO) {

    log.info("createBook start... ");

    Category category = bookDTO.getCategoryId() != null
        ? categoryDAO.getAllCategories(null).stream()
        .filter(e -> e.getId().equals(bookDTO.getCategoryId()))
        .findFirst()
        .orElseThrow(()-> new EntityNotFoundException("Category not found"))
        : null;

    Book book = toEntity(bookDTO);
    book.setCategory(category);

    Book saveBook = bookDAO.addBook(book);
    return toDTO(saveBook);
  }

  @Override
  public BookDTO updateBook(long id, BookDTO bookDTO) {

    log.info("updateBook start... ");

    Category category = bookDTO.getCategoryId() != null
        ? categoryDAO.getAllCategories(null).stream()
        .filter(e -> e.getId().equals(bookDTO.getCategoryId()))
        .findFirst()
        .orElseThrow(()-> new EntityNotFoundException("Category not found"))
        : null;

    Book existingBook = bookDAO.getBook(id);

    String imageUrl = switch (bookDTO.getCategoryId().intValue())
    { case 1 -> "https://via.placeholder.com/150x150/000080";
      case 2 -> "https://via.placeholder.com/150x150/00FF00";
      case 3 -> "https://via.placeholder.com/150x150/0000FF";
      case 4 -> "https://via.placeholder.com/150x150/FFFF00";
      default -> "https://via.placeholder.com/150x150/CCCCCC";
    };

    existingBook.setTitle(bookDTO.getTitle());
    existingBook.setAuthor(bookDTO.getAuthor());
    existingBook.setDescription(bookDTO.getDescription());
    existingBook.setPublisher(bookDTO.getPublisher());
    existingBook.setCategory(category);
    existingBook.setImgsrc(imageUrl);

    Book resultBook = bookDAO.updateBook(id, existingBook);
    return toDTO(resultBook);
  }

  @Override
  public void deleteBook(long id) {
    log.info("deleteBook start... ");
    bookDAO.deleteBook(id);
  }

  @Override
  public List<BookDTO> searchBook(String title) {
    List<Book> bookList = bookDAO.searchBook(title);
    return bookList.stream().map(this::toDTO).toList();
  }

}
