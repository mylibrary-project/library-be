package com.example.librarybe.book.exception;

public class BookAlreadyRentedException extends RuntimeException {
  public BookAlreadyRentedException(String messgae) {
    super(messgae);
  }
}

