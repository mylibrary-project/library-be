package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.data.entity.Book;
import java.util.List;

public interface BookService {

  /**
   * 모든 책 정보 보내기
   * @param categoryId
   * @return 모든 책 정보
   */
  List<BookDTO> getAllBooks(Long categoryId);

  /**
   * 책 한권 정보 보내기
   * @param id
   * @return 책 한권 정보
   */
  BookDTO getBook(long id);

  /**
   * 책 추가 하기
   * @param bookDTO
   * @return title, author, desc, publisher, categoryId
   */
  BookDTO createBook(BookDTO bookDTO);

  /**
   * 책 정보 수정하기
   * @param id
   * @param bookDTO
   * @return 수정된 책 정보
   */
  BookDTO updateBook(long id, BookDTO bookDTO);

  /**
   * 책 삭제
   * @param id
   */
  void deleteBook(long id);

  List<BookDTO> searchBook(String title);

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
    String imageUrl = switch (bookDTO.getCategoryId().intValue()) {
      case 1 -> "https://via.placeholder.com/150x150/000080";
      case 2 -> "https://via.placeholder.com/150x150/00FF00";
      case 3 -> "https://via.placeholder.com/150x150/0000FF";
      case 4 -> "https://via.placeholder.com/150x150/FFFF00";
      default -> "https://via.placeholder.com/150x150/CCCCCC";
    };

    return Book.builder()
        .title(bookDTO.getTitle())
        .author(bookDTO.getAuthor())
        .rented(bookDTO.isRented())
        .description(bookDTO.getDescription())
        .publisher(bookDTO.getPublisher())
        .imgsrc(imageUrl)
        .build();
  }

}
