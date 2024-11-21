package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
