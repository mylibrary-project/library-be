package com.example.librarybe.book.data.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

  private Long id;
  private String title;
  private boolean rented;
  private String author;
  private String publisher;
  private String description;
  private String imgsrc;
  private Long categoryId;
  private String categoryName;
}
