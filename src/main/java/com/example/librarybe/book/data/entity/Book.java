package com.example.librarybe.book.data.entity;

import com.example.librarybe.category.data.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "이름은 비어있을 수 없습니다")
  @Size(min = 1)
  private String title;

  @ColumnDefault("fault")
  @Column(name = "rented")
  private boolean rented;

  @NotNull(message = "저자는 비어있을 수 없습니다")
  @Size(min = 1)
  private String author;

  private String imgsrc;

  @NotNull(message = "출판사는 비어있을 수 없습니다")
  @Size(min = 1)
  private String publisher;

  @Size(min= 5, max = 200)
  private String description;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
}

