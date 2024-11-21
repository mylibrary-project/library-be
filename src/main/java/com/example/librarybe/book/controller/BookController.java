package com.example.librarybe.book.controller;

import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.exception.CustomException;
import com.example.librarybe.book.service.BookService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> detail(@PathVariable long id) {
    try {
      return ResponseEntity.ok(bookService.getBook(id));
    } catch (Exception e) {
      throw new CustomException("Book not found");
    }
  }

  @PostMapping
  public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
    BookDTO createdBook = bookService.createBook(bookDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDTO> updateBook(@Valid @PathVariable long id, @RequestBody BookDTO bookDTO) {
    try {
      BookDTO updatedBook = bookService.updateBook(id, bookDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    } catch (Exception e) {
      throw new CustomException("Book update failed");
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable long id) {
    try {
      bookService.deleteBook(id);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      throw new CustomException("Book delete failed");
    }

  }

}
