package com.example.librarybe.book.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
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

  @OneToMany(fetch= FetchType.LAZY, mappedBy = "book")
  private List<Rent> rentList = new ArrayList<>();
}

// 외래키 설정하는 곳이 주인, mappedBy

